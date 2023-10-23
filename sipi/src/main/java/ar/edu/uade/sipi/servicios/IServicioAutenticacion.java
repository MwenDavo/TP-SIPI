package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;

public interface IServicioAutenticacion {

    void registro(Usuario usuario);

    Usuario inicioSesion(String nombreUsuario, String contraseña);

    void generarContraseñaProvisoria(String correoElectronico);
}
