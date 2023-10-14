package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOMetodologia;
import ar.edu.uade.sipi.servicios.IServicioTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControladorTest {

    @Autowired
    private IServicioTest servicioTest;

    @GetMapping(value = "/getvaloresUsuario")
    public ResponseEntity<DTOMetodologia> getValoresUsuario(@RequestBody int[] valoresUsuario){
        DTOMetodologia metodologiaRecomendada = toDTO(servicioTest.guardarValoresUsuario(valoresUsuario));
        return new ResponseEntity<>(metodologiaRecomendada, HttpStatus.OK);
    }

    private DTOMetodologia toDTO(Metodologia metodologia){
        return new DTOMetodologia(metodologia.getNombre());
    }



}
