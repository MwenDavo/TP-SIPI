package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Usuario;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOUsuario;
import ar.edu.uade.sipi.servicios.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
@Autowired
private IServicioUsuario servicioUsuario;
    @PutMapping("/update/parameters")
    public void update(@RequestParam("nombreUsuario") String nombreUsuario, @RequestBody DTOUsuario dtoUsuario){
        Usuario usuario = ConvertToEntity(dtoUsuario);
        servicioUsuario.update(nombreUsuario, usuario);

    }

    private Usuario ConvertToEntity(DTOUsuario dtoUsuario) {
        return new Usuario(
          dtoUsuario.getCorreoElectronico()
        );
    }

}
