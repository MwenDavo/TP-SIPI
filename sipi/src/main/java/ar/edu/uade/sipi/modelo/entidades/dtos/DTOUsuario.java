package ar.edu.uade.sipi.modelo.entidades.dtos;

public class DTOUsuario {
    private String nombreUsuario;
    private String contraseña;
    private String correoElectronico;

    public DTOUsuario(){}

    public DTOUsuario(String nombreUsuario, String contraseña, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
    }

    public DTOUsuario(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
