package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.repositorios.IRepositorioSecuencia;
import ar.edu.uade.sipi.modelo.util.SecuenciaGuardado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioSecuenciador extends ServicioGenerico<SecuenciaGuardado, String> implements IServicioSecuenciador {
    @Autowired
    private IRepositorioSecuencia repositorioSecuencia;

    public Long secuenciar(String nombreSecuencia) {
        SecuenciaGuardado secuenciaGuardado = this.get(nombreSecuencia);
        Long secuencia;
        if (secuenciaGuardado != null) {
            secuencia = secuenciaGuardado.getSecuencia() + 1;
        } else {
            secuencia = 0L;
        }
        this.save(new SecuenciaGuardado(nombreSecuencia, secuencia));
        return secuencia;
    }

    @Override
    public CrudRepository<SecuenciaGuardado, String> getDao() {
        return repositorioSecuencia;
    }
}
