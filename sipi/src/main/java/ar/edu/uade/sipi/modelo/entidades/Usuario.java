package ar.edu.uade.sipi.modelo.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {
    @Transient
    public static final String NOMBRE_SECUENCIA = "usuarios";
    @Id
    private Long id;
    @Indexed(unique = true)
    private String nombreUsuario;
    private String contraseña;
    private String metodologiaRecomendada;

    @Indexed(unique = true)
    private String correoElectronico;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
    }

    public Usuario(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMetodologiaRecomendada() {
        return metodologiaRecomendada;
    }

    public void setMetodologiaRecomendada(String metodologiaRecomendada) {
        this.metodologiaRecomendada = metodologiaRecomendada;
    }
}
