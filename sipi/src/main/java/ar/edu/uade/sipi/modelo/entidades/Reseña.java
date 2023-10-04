package ar.edu.uade.sipi.modelo.entidades;

public class Reseña {
    private long id;
    private int puntuacion;
    private Usuario usuario;
    private String descripcion;

    public Reseña(long id, int puntuacion, Usuario usuario, String descripcion) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
