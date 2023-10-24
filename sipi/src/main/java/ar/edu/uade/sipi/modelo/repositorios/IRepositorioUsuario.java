package ar.edu.uade.sipi.modelo.repositorios;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IRepositorioUsuario extends MongoRepository<Usuario, Long> {

    @Query("{nombreUsuario:'?0'}")
    Usuario getByNombreUsuario(String nombreUsuario);

    @Query("{correoElectronico: '?0'}")
    Usuario getFirstByCorreoElectronico(String correoElectronico);
}
