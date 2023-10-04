package ar.edu.uade.sipi.modelo.entidades.dtos;

import ar.edu.uade.sipi.modelo.entidades.Usuario;

public class DTOReseña {
    private int puntuacion;
    private DTOUsuario usuario;
    private String descripcion;

    public DTOReseña(int puntuacion, DTOUsuario usuario, String descripcion) {
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.descripcion = descripcion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
