package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioMetodologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioMetodologia extends ServicioGenerico<Metodologia, Long> implements IServicioMetodologia {
    @Autowired
    private IRepositorioMetodologia repositorioMetodologia;

    @Override
    public CrudRepository<Metodologia, Long> getDao() {
        return repositorioMetodologia;
    }

    @Override
    public Metodologia getByNombre(String nombre) {
        return repositorioMetodologia.getByNombre(nombre);
    }
}
