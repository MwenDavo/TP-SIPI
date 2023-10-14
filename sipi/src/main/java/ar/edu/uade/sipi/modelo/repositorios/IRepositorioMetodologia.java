package ar.edu.uade.sipi.modelo.repositorios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import com.google.gson.JsonArray;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IRepositorioMetodologia extends MongoRepository<Metodologia, Long> {

    @Query(" {nombre:'?0'}")
    Metodologia getByNombre(String nombre);

    @Query(fields = "{'nombre':1,'valoresMetodo':1}")
    JsonArray getValores();
}
