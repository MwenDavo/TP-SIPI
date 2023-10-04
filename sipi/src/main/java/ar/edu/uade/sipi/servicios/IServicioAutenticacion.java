package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;

public interface IServicioAutenticacion extends IServicioGenerico<Usuario, Long> {

    Usuario login(String nombreUsuario, String contraseña);
}
