package ar.edu.uade.sipi.modelo.util;

public class ResultadoUsuario {
    private String nombreUsuario;
    private String valoresUsuario;

    public ResultadoUsuario(){

    }
    public ResultadoUsuario(String nombreUsuario, String valoresUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.valoresUsuario = valoresUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getValoresUsuario() {
        return valoresUsuario;
    }

    public void setValoresUsuario(String valoresUsuario) {
        this.valoresUsuario = valoresUsuario;
    }
}
