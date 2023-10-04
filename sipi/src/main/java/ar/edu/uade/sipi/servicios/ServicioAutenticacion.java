package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
import ar.edu.uade.sipi.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion extends ServicioGenerico<Usuario, Long> implements IServicioAutenticacion {
    @Autowired
    private IRepositorioUsuario repositorioUsuario;
    @Autowired
    private IServicioSecuenciador servicioSecuenciador;

    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return repositorioUsuario;
    }

    @Override
    public Usuario save(Usuario entity) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        entity.setContraseña(
                passwordEncoder.encode(
                        entity.getContraseña()
                )
        );
        entity.setId(servicioSecuenciador.secuenciar(Usuario.nombreSecuencia));
        return super.save(entity);
    }

    @Override
    public Usuario login(String nombreUsuario, String contraseña) {
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
