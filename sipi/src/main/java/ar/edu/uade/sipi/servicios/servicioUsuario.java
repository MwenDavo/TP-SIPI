package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioUsuario implements IServicioUsuario{
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public void update(String nombreUsuario, Usuario usuario) {
        Usuario u = repositorioUsuario.getByNombreUsuario(nombreUsuario);
        u.setCorreoElectronico(usuario.getCorreoElectronico());
        repositorioUsuario.save(u);
    } //TODO modificar y hacer que se pueda cambiar la contraseña tambien
}
