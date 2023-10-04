package ar.edu.uade.sipi.modelo.entidades.dtos;

public class DTOUsuario {
    private String nombreUsuario;
    private String contraseña;
    private String email;
    private String metodologiaRecomendada;

    public DTOUsuario(String nombreUsuario, String contraseña, String email, String metodologiaRecomendada) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
        this.metodologiaRecomendada = metodologiaRecomendada;
    }

    public DTOUsuario(String nombreUsuario, String email, String metodologiaRecomendada) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.metodologiaRecomendada = metodologiaRecomendada;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetodologiaRecomendada() {
        return metodologiaRecomendada;
    }

    public void setMetodologiaRecomendada(String metodologiaRecomendada) {
        this.metodologiaRecomendada = metodologiaRecomendada;
    }
}
