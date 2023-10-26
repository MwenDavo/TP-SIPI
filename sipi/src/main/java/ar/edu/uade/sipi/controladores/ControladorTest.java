package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.entidades.Metodologia;
import ar.edu.uade.sipi.modelo.entidades.dtos.DTOMetodologia;
import ar.edu.uade.sipi.modelo.util.Lista;
import ar.edu.uade.sipi.servicios.IServicioTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.ArrayList;
//.
@RestController
@RequestMapping("/test")
public class ControladorTest {

    @Autowired
    private IServicioTest servicioTest;

    @PostMapping ("/resultados")
    public ResponseEntity<?> resultados(@RequestBody Lista valoresUsuario) {
        System.out.println(valoresUsuario.getValoresUsuario());
        String metodologiaRecomendada = servicioTest.guardarValoresUsuario(valoresUsuario.getValoresUsuario());
        return new ResponseEntity<>(metodologiaRecomendada, HttpStatus.OK);
    }
}
