package ar.edu.uade.sipi.modelo.util;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secuencias_guardado")
public class SecuenciaGuardado {
    @Id
    private String nombre;
    private Long secuencia;

    public SecuenciaGuardado() {
    }

    public SecuenciaGuardado(String nombre, Long secuencia) {
        this.nombre = nombre;
        this.secuencia = secuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }
}
