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

    ArrayList<Integer> valoresUsuario;

    public KNN(JsonArray metodosJson, ArrayList<Integer> valoresUsuario){
        this.metodosJson = metodosJson;
        Gson gson = new Gson();
        this.metodos = gson.fromJson(metodosJson,ArrayList.class);
        this.valoresUsuario = valoresUsuario;
    }

    public Metodologia SeleccionMejorMetodo(ArrayList<Metodologia> valoresMetodos) {
        Metodologia mayorRepetida = new Metodologia();
        int mayorCantidad = 0;
        for(Metodologia m: valoresMetodos){
            int count = 0;
            for (Metodologia m1:valoresMetodos) {
                if (m.equals(m1)){
                    count+=1;
                }
            }
            if (count>mayorCantidad){
                mayorCantidad = count;
                mayorRepetida = m;
            }
        }


        return mayorRepetida;
    }

    public  ArrayList<Metodologia> CalculoKNN() {
        ArrayList<Metodologia> metodosElegidos = new ArrayList<>();

        for(int i = 0;i<=valoresUsuario.size();i++){

            int MenorDist = Integer.MAX_VALUE;

            for (Metodologia metodo: metodos){

                MenorDist = Math.min(MenorDist,Math.abs(valoresUsuario.get(i) - metodo.getValoresMetodo().get(i)));//ECUACION MANHATTAN
                if (MenorDist == Math.abs(valoresUsuario.get(i) - metodo.getValoresMetodo().get(i))){//ECUACION MANHATTAN
                    metodosElegidos.add(i,metodo);
                }
            }
        }
        return metodosElegidos;
    }



}
