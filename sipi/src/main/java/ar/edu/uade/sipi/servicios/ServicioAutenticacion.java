package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioAutenticacion implements IServicioAutenticacion {
    @Autowired
    private IRepositorioUsuario repositorioUsuario;
    @Autowired
    private IServicioSecuenciaGuardado servicioSecuenciaGuardado;
    @Autowired
    private IServicioCorreo servicioCorreo;

    @Override
    public void registro(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setContraseña(
                passwordEncoder.encode(
                        usuario.getContraseña()
                )
        );
        usuario.setId(servicioSecuenciaGuardado.get(Usuario.NOMBRE_SECUENCIA));
        List<Usuario> u = new ArrayList<>();
        u.add(usuario);
        repositorioUsuario.saveAll(u);
    }

    @Override
    public Usuario inicioSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = repositorioUsuario.getByNombreUsuario(nombreUsuario);
        if (usuario != null && checkPassword(contraseña, usuario.getContraseña())) {
            return usuario;
        }
        return null;
    }

    private boolean checkPassword(String ingresada, String registrada) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(ingresada, registrada);
    }

    @Override
    public void generarContraseñaProvisoria(String correoElectronico) {
        Usuario usuario = repositorioUsuario.getByCorreoElectronico(correoElectronico);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        SecureRandom secureRandom = new SecureRandom();
        String caracteresDisponibles = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSQUVWXYZ0123456789,;.:-_+*{[}]/";
        StringBuilder nuevaContraseña = new StringBuilder();
        for (int i = 0; i <= 12; i++) {
            int randomIndex = secureRandom.nextInt(caracteresDisponibles.length());
            nuevaContraseña.append(caracteresDisponibles.charAt(randomIndex));
        }
        usuario.setContraseña(passwordEncoder.encode(nuevaContraseña.toString()));
        repositorioUsuario.save(usuario);
        servicioCorreo.enviarCorreoContraseñaProvisoria(usuario, nuevaContraseña.toString());
    }
}
