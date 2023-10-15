package ar.edu.uade.sipi.modelo.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "metodos_estudio")
public class Metodologia {
    @Transient
    public static final String NOMBRE_SECUENCIA = "metodologias";
    @Id
    private Long id;
    @Indexed(unique = true)
    private String nombre;
    private String contenido;
    private List<Reseña> reseñas;
    private int puntuacionTotal;

    private ArrayList<Integer> valoresMetodo;

    public Metodologia() {
    }

    public Metodologia (String nombre, ArrayList<Integer> valoresMetodo){
        this.nombre = nombre;
        this.valoresMetodo = valoresMetodo;
    }

    public Metodologia(String nombre, String contenido, List<Reseña> reseñas, int puntuacionTotal, ArrayList<Integer> valoresMetodo) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.reseñas = reseñas;
        this.puntuacionTotal = puntuacionTotal;
        this.valoresMetodo = valoresMetodo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<Integer> getValoresMetodo() {
        return valoresMetodo;
    }

    public void setValoresMetodo(ArrayList<Integer> valoresMetodo) {
        this.valoresMetodo = valoresMetodo;
    }
}
