package ar.edu.uade.sipi.modelo.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reseñas")
public class Reseña {
    @Transient
    public static final String NOMBRE_SECUENCIA = "reseñas";
    @Id
    private Long id;
    private int puntuacion;
    private Usuario usuario;

    public Reseña() {
    }

    public Reseña(int puntuacion, Usuario usuario) {
        this.puntuacion = puntuacion;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
