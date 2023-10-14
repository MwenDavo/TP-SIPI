package ar.edu.uade.sipi.modelo.util;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class KNN {
    private JsonArray metodosJson;

    ArrayList<Metodologia> metodos;

    int[] valoresUsuario;

    public KNN(JsonArray metodosJson, int[] valoresUsuario){
        this.metodosJson = metodosJson;
        Gson gson = new Gson();
        this.metodos = gson.fromJson(metodosJson,ArrayList.class);
        this.valoresUsuario = valoresUsuario;
    }

    public Metodologia SeleccionMejorMetodo(ArrayList<Metodologia> valoresMetodos) {

        return valoresMetodos.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    public  ArrayList<Metodologia> CalculoKNN() {
        ArrayList<Metodologia> metodosElegidos = new ArrayList<>();

        for(int i = 0;i<=valoresUsuario.length;i++){

            int MenorDist = Integer.MAX_VALUE;

            for (Metodologia metodo: metodos){

                MenorDist = Math.min(MenorDist,Math.abs(valoresUsuario[i] - metodo.getValoresMetodo()[i]));//ECUACION MANHATTAN
                if (MenorDist == Math.abs(valoresUsuario[i] - metodo.getValoresMetodo()[i])){//ECUACION MANHATTAN
                    metodosElegidos.add(i,metodo);
                }
            }
        }
        return metodosElegidos;
    }



}
