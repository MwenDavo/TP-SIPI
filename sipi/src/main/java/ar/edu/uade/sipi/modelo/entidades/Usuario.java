package ar.edu.uade.sipi.modelo.entidades;

public class Usuario {
    private long id;
    private String nombreUsuario;
    private String contraseña;
    private String email;
    private String metodologiaRecomendada;

    public Usuario(long id, String nombreUsuario, String contraseña, String email, String metodologiaRecomendada) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
        this.metodologiaRecomendada = metodologiaRecomendada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
