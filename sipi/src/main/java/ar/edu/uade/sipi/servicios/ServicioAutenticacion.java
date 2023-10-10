package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioAutenticacion implements IServicioAutenticacion {
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public void registro(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setContraseña(
                passwordEncoder.encode(
                        usuario.getContraseña()
                )
        );
        usuario.setId(1L);
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        repositorioUsuario.saveAll(usuarios);
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
}
