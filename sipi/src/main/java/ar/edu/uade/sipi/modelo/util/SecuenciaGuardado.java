package ar.edu.uade.sipi.modelo.util;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secuencias_guardado")
public class SecuenciaGuardado {
    @Id
    private String id;
    private Long secuencia;

    public SecuenciaGuardado() {
    }

    public SecuenciaGuardado(String id, Long secuencia) {
        this.id = id;
        this.secuencia = secuencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }
}
