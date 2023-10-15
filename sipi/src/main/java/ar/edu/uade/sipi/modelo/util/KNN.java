package ar.edu.uade.sipi.modelo.util;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KNN {
    List<Metodologia> metodos;
    List<Integer> valoresUsuario;


    public KNN(List<Metodologia> metodos, List<Integer> valoresUsuario){
        this.metodos = metodos;
        this.valoresUsuario = valoresUsuario;
    }

    public String SeleccionMejorMetodo(List<String> metodosSeleccionados) {
        String mayorRepetida = "";
        int mayorCantidad = 0;
        for(Metodologia m: metodos){
            int count = 0;
            for (String s : metodosSeleccionados) {
                if (s.equals(m.getNombre())){
                    count += 1;
                }
            }
            if (count>mayorCantidad){
                mayorCantidad = count;
                mayorRepetida = m.getNombre();
            }
        }
        return mayorRepetida;
    }

    public List<String> CalculoKNN() {
        List<String> metodosElegidos = new ArrayList<>();

        for(int i = 0;i<valoresUsuario.size();i++){

            int MenorDist = Integer.MAX_VALUE;

            String menor = "";

            for (Metodologia metodo: metodos){

                MenorDist = Math.min(MenorDist,Math.abs(valoresUsuario.get(i) - metodo.getValoresMetodo().get(i)));//ECUACION MANHATTAN
                if (MenorDist == Math.abs(valoresUsuario.get(i) - metodo.getValoresMetodo().get(i))){//ECUACION MANHATTAN
                    menor = metodo.getNombre();
                }

            }
            metodosElegidos.add(menor);
        }

        return metodosElegidos;
    }
}
