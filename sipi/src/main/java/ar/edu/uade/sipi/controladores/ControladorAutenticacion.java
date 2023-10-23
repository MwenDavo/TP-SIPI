package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOUsuario;
import ar.edu.uade.sipi.servicios.IServicioAutenticacion;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;

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
        if (servicioAutenticacion.inicioSesion(usuario.getNombreUsuario(), usuario.getContraseña()) != null) {
            String token = Jwts.builder()
                    .setSubject(usuario.getNombreUsuario())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_HOURS * 60 * 60 * 1000))
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/olvidoContraseña")
    public void olvidoContraseña(@RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = convertToEntity(dtoUsuario);
        servicioAutenticacion.generarContraseñaProvisoria(usuario.getCorreoElectronico());
    }

    private Usuario convertToEntity(DTOUsuario dtoUsuario) {
        return new Usuario(
                dtoUsuario.getNombreUsuario(),
                dtoUsuario.getContraseña(),
                dtoUsuario.getCorreoElectronico()
        );
    }
}
