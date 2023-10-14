package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioMetodologia;
import ar.edu.uade.sipi.modelo.util.KNN;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTest implements IServicioTest{
    @Autowired
    IRepositorioMetodologia repositorioMetodologia;

    @Override
    public Metodologia guardarValoresUsuario(ArrayList<Integer> valoresUsuario) {
        JsonArray jsonArray = ConvertToJsonArray(repositorioMetodologia.getValores());
        KNN knn = new KNN(jsonArray,valoresUsuario);
        ArrayList<Metodologia> metodosElegidos =  knn.CalculoKNN();
        return knn.SeleccionMejorMetodo(metodosElegidos);
    }

    private JsonArray ConvertToJsonArray(List<Metodologia> valores) {
        JsonArray jsonArray = new JsonArray();
        Gson gson = new Gson();
        for (Metodologia m:valores){
            jsonArray.add(gson.toJson(m));
        }
        return jsonArray;
    }
}
