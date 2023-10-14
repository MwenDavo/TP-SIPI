package ar.edu.uade.sipi.modelo.util;

import java.util.ArrayList;

public class Lista {
    private ArrayList<Integer> valoresUsuario;

public Lista(){
}

public Lista(ArrayList<Integer> valoresUsuario){
    this.valoresUsuario = valoresUsuario;
}

    public ArrayList<Integer> getValoresUsuario() {
        return valoresUsuario;
    }

    public void setValoresUsuario(ArrayList<Integer> valoresUsuario) {
        this.valoresUsuario = valoresUsuario;
    }
}
