package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.Reseña;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOMetodologia;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOReseña;
import ar.edu.uade.sipi.servicios.IServicioMetodologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/metodologias")
public class ControladorMetodologia {
    @Autowired
    private IServicioMetodologia servicioMetodologia;

    @GetMapping(value = "/get/parameters")
    public ResponseEntity<DTOMetodologia> get(@RequestParam("nombre") String nombre) {
        Metodologia metodologia = servicioMetodologia.getByNombre(nombre);
        if (metodologia != null) {
            return new ResponseEntity<>(convertToDTO(metodologia), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping (value = "/put/reseñas")
    public void updateMetodo(@RequestBody DTOMetodologia dtoMetodologia) {
        Metodologia metodologia = convertToEntity(dtoMetodologia);
        servicioMetodologia.updateMetodologia(metodologia);
    }

    private Metodologia convertToEntity(DTOMetodologia dtoMetodologia) {
        return null; //TODO hacer convert to entity
    }

    @GetMapping(value = "/all")
    public List<DTOMetodologia> getAll() {
        List<Metodologia> metodologias = servicioMetodologia.getAll();
        List<DTOMetodologia> dtosMetodologias = new ArrayList<>();
        for (Metodologia metodologia : metodologias) {
            dtosMetodologias.add(convertToDTO(metodologia));
        }
        return dtosMetodologias;
    }

    private DTOMetodologia convertToDTO(Metodologia metodologia) {
        List<DTOReseña> dtosReseñas = new ArrayList<>();
        for (Reseña reseña : metodologia.getReseñas()) {
            dtosReseñas.add(convertToDTO(reseña));
        }
        return new DTOMetodologia(
                metodologia.getNombre(),
                metodologia.getContenido(),
                dtosReseñas,
                metodologia.getPuntuacionTotal()
        );
    }

    private DTOReseña convertToDTO(Reseña reseña) {
        return new DTOReseña(
                reseña.getPuntuacion()
        );
    }
}
