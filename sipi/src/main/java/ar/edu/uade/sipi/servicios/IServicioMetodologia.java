package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;

public interface IServicioMetodologia extends IServicioGenerico<Metodologia, Long> {

    Metodologia getByNombre(String nombre);
}
