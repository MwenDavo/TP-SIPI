package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;

public interface IServicioCorreo {

    void enviarCorreoContraseñaProvisoria(Usuario usuario, String contraseñaProvisoria);
}
