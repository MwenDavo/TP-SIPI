package ar.edu.uade.sipi.modelo.entidades.dtos;

import java.util.List;

public class DTOMetodologia {
    private String nombre;
    private String contenido;
    private List<DTOReseña> reseñas;
    private int puntuacionTotal;

    public DTOMetodologia(String nombre, String contenido, List<DTOReseña> reseñas, int puntuacionTotal) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.reseñas = reseñas;
        this.puntuacionTotal = puntuacionTotal;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<DTOReseña> getReseñas() {
        return reseñas;
    }

    public void setReseñas(List<DTOReseña> reseñas) {
        this.reseñas = reseñas;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}
