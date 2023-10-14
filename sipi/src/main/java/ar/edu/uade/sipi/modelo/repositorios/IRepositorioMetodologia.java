package ar.edu.uade.sipi.modelo.repositorios;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import com.google.gson.JsonArray;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IRepositorioMetodologia extends MongoRepository<Metodologia, Long> {

    @Query(" {nombre:'?0'}")
    Metodologia getByNombre(String nombre);

    @Query(value = "{ '_id' : { $gt: 0 }}", fields = "{'nombre': 1,'valoresMetodo': 1}")
    List<Metodologia> getValores(); //todo corregir metodologias recibidas ---> recibe vacia la lista
}
