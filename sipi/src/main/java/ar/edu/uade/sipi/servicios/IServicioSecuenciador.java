package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.util.SecuenciaGuardado;

public interface IServicioSecuenciador extends IServicioGenerico<SecuenciaGuardado, String> {
    Long secuenciar(String nombreSecuencia);
}
