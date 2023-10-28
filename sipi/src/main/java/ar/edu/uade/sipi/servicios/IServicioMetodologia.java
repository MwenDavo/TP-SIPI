package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServicioMetodologia {

    Metodologia getByNombre(String nombre);

    List<Metodologia> getAll();

    void updateMetodologia(Metodologia metodologia);

    Usuario devolverUsuario(String nombreUsaurio);
}
