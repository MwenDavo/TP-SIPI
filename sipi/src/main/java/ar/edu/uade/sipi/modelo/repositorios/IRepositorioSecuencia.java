package ar.edu.uade.sipi.modelo.repositorios;

import ar.edu.uade.sipi.modelo.util.SecuenciaGuardado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRepositorioSecuencia extends MongoRepository<SecuenciaGuardado, String> {
}
