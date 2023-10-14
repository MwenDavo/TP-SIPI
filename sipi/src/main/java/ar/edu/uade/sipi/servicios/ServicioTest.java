package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioMetodologia;
import ar.edu.uade.sipi.modelo.util.KNN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public class ServicioTest implements IServicioTest{
    @Autowired
    IRepositorioMetodologia repositorioMetodologia;

    @Override
    public Metodologia guardarValoresUsuario(int[] valoresUsuario) {
        KNN knn = new KNN(repositorioMetodologia.getValores(),valoresUsuario);
        ArrayList<Metodologia> metodosElegidos =  knn.CalculoKNN();
        return knn.SeleccionMejorMetodo(metodosElegidos);
    }
}
