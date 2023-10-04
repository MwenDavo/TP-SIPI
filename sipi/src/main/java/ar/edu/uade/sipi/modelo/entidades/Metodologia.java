package ar.edu.uade.sipi.modelo.entidades;

import java.util.List;

public class Metodologia {
    private long id;
    private String contenido;
    private List<Reseña> reseñas;
    private int puntuacionTotal;

    public Metodologia(long id, String contenido, List<Reseña> reseñas, int puntuacionTotal) {
        this.id = id;
        this.contenido = contenido;
        this.reseñas = reseñas;
        this.puntuacionTotal = puntuacionTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Reseña> getReseñas() {
        return reseñas;
    }

    public void setReseñas(List<Reseña> reseñas) {
        this.reseñas = reseñas;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}
