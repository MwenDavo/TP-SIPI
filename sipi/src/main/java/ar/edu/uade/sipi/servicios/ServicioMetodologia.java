package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioMetodologia;
import ar.edu.uade.sipi.modelo.repositorios.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMetodologia implements IServicioMetodologia {
    @Autowired
    private IRepositorioMetodologia repositorioMetodologia;
    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    @Override
    public Metodologia getByNombre(String nombre) {
        return null;
    }

    @Override
    public List<Metodologia> getAll() {
        return null;
    }

    @Override
    public void updateMetodologia(Metodologia metodologia) {
        repositorioMetodologia.save(metodologia);
    }

    @Override
    public Usuario devolverUsuario(String nombreUsaurio) {
        return repositorioUsuario.getByNombreUsuario(nombreUsaurio);
    }
}
