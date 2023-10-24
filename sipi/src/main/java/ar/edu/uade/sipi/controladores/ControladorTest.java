package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOMetodologia;
import ar.edu.uade.sipi.modelo.util.Lista;
import ar.edu.uade.sipi.servicios.IServicioTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/test")
public class ControladorTest {

    @Autowired
    private IServicioTest servicioTest;

    @PostMapping(value = "/getvaloresUsuario")
    public ResponseEntity<String> getValoresUsuario(@RequestBody Lista valoresUsuario) {
        String metodologiaRecomendada = servicioTest.guardarValoresUsuario(valoresUsuario.getValoresUsuario());
        return new ResponseEntity<>(metodologiaRecomendada, HttpStatus.OK);
    }


}
