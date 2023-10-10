package ar.edu.uade.sipi.modelo.repositorios;

import ar.edu.uade.sipi.modelo.util.SecuenciaGuardado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRepositorioSecuenciaGuardado extends MongoRepository<SecuenciaGuardado, String> {
}
