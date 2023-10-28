package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;

public interface IServicioAutenticacion {

    void registro(Usuario usuario);

    public Usuario devolverUsuario(String nombreUsuario);

    Usuario inicioSesion(String nombreUsuario, String contraseña);

    void generarContraseñaProvisoria(String correoElectronico);

    Usuario inicioSesionGoogle(String correoElectronico);
}
