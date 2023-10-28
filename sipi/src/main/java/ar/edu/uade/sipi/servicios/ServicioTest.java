package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioMetodologia;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
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
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public String guardarValoresUsuario(String nombreUsuario,List<Integer> valoresUsuario) {
        KNN knn = new KNN(repositorioMetodologia.getValores(),valoresUsuario);
        List<String> metodosElegidos =  knn.CalculoKNN();
        String metodoElegido = knn.SeleccionMejorMetodo(metodosElegidos);

        //busca usuario, updateea, y guarda en base de datos
        Usuario user = repositorioUsuario.getByNombreUsuario(nombreUsuario);
        user.setMetodologiaRecomendada(metodoElegido);
        repositorioUsuario.save(user);
        return metodoElegido;
    }
}
