package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;

import java.util.ArrayList;
import java.util.List;

public interface IServicioTest {
    String guardarValoresUsuario(String nombreUsuario,List<Integer> valoresUsuario);
}
