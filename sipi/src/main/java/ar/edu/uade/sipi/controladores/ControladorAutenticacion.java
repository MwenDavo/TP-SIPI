package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOUsuario;
import ar.edu.uade.sipi.servicios.IServicioAutenticacion;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

@RestController
@RequestMapping("/autenticacion")
public class ControladorAutenticacion {
    @Autowired
    private IServicioAutenticacion servicioAutenticacion;
    @Autowired
    private SecretKey secretKey;
    private final int EXPIRATION_TIME_IN_HOURS = 24;

    @PostMapping("/registro")
    private ResponseEntity<?> register(@RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = convertToEntity(dtoUsuario);
        servicioAutenticacion.registro(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/inicioSesion", consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> login(@RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = convertToEntity(dtoUsuario);
        if (usuario.getContraseña() != null) {
            if (servicioAutenticacion.inicioSesion(usuario.getNombreUsuario(), usuario.getContraseña()) != null) {
                String token = Jwts.builder()
                        .setSubject(usuario.getNombreUsuario())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_HOURS * 60 * 60 * 1000))
                        .signWith(secretKey, SignatureAlgorithm.HS256)
                        .compact();

                Usuario user = servicioAutenticacion.inicioSesion(usuario.getNombreUsuario(), usuario.getContraseña());
                Gson gson = new Gson();
                Map<String, Object> usuario_token = new HashMap<>();
                usuario_token.put("nombreUsuario",user.getNombreUsuario());
                usuario_token.put("correoElectronico",user.getCorreoElectronico());
                usuario_token.put("token",token);
                String json= gson.toJson(usuario_token);

                /*JsonObject json = new JsonObject();
                json.addProperty("nombreUsuario",user.getNombreUsuario());
                json.addProperty("correoElectronico",user.getCorreoElectronico());
                json.addProperty("token",token);*/

                return new ResponseEntity<>(json, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/cerrarSesion")
    public void deslogeo() {

    }

    @PostMapping(value = "/olvidoContraseña")
    public void olvidoContraseña(@RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = convertToEntity(dtoUsuario);
        servicioAutenticacion.generarContraseñaProvisoria(usuario.getCorreoElectronico());
    }

    @PostMapping(value = "/inicioSesion/Google")
    public ResponseEntity<?> inicioSesionGoogle(String idTokenString) throws GeneralSecurityException, IOException {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList("study_mentor"))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

        // (Receive idTokenString by HTTPS POST)

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = payload.getEmailVerified();
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");

            // Use or store profile information
            // ...
            Usuario usuario = servicioAutenticacion.inicioSesionGoogle(email);
            if (usuario == null) {
                usuario = new Usuario(email);
                String[] s = email.split("@");
                String nombreUsuario = s[0];
                usuario.setNombreUsuario(nombreUsuario);
                servicioAutenticacion.registro(usuario);
            } else {
                String token = Jwts.builder()
                        .setSubject(usuario.getNombreUsuario())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_HOURS * 60 * 60 * 1000))
                        .signWith(secretKey, SignatureAlgorithm.HS256)
                        .compact();
                return new ResponseEntity<>(token, HttpStatus.OK);
            }

        } else {
            System.out.println("Invalid ID token.");
        }
        return null;
    }

    private Usuario convertToEntity(DTOUsuario dtoUsuario) {
        return new Usuario(
                dtoUsuario.getNombreUsuario(),
                dtoUsuario.getContraseña(),
                dtoUsuario.getCorreoElectronico()
        );
    }
}
