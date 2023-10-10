package ar.edu.uade.sipi.servicios;

import ar.edu.uade.sipi.modelo.repositorios.IRepositorioSecuenciaGuardado;
import ar.edu.uade.sipi.modelo.util.SecuenciaGuardado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioSecuenciaGuardado implements IServicioSecuenciaGuardado {
    @Autowired
    private IRepositorioSecuenciaGuardado repositorioSecuenciaGuardado;

    @Override
    public Long get(String nombre) {
        SecuenciaGuardado secuenciaGuardado;
        if (repositorioSecuenciaGuardado.existsById(nombre)) {
            Optional<SecuenciaGuardado> s = repositorioSecuenciaGuardado.findById(nombre);
            secuenciaGuardado = new SecuenciaGuardado(nombre, s.get().getSecuencia()+1);
        } else {
            secuenciaGuardado = new SecuenciaGuardado(nombre, 0L);
        }
        repositorioSecuenciaGuardado.save(secuenciaGuardado);
        return secuenciaGuardado.getSecuencia();
    }
}
