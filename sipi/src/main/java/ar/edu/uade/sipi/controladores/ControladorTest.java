package ar.edu.uade.sipi.controladores;

import ar.edu.uade.sipi.modelo.util.ResultadoUsuario;
import ar.edu.uade.sipi.servicios.IServicioAutenticacion;
import ar.edu.uade.sipi.servicios.IServicioTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//.
@RestController
@RequestMapping("/test")
public class ControladorTest {

    @Autowired
    private IServicioTest servicioTest;

    @Autowired
    private IServicioAutenticacion servicioAutenticacion;

    @PostMapping ("/resultados")
    public ResponseEntity<?> resultados(@RequestBody ResultadoUsuario resultadoUsuario) {
        String valoresUsuario = resultadoUsuario.getValoresUsuario();
        System.out.println(valoresUsuario);
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < valoresUsuario.length(); i++) {
            if (valoresUsuario.charAt(i) != '"') {
                if (valoresUsuario.charAt(i) == '1' && valoresUsuario.charAt(i+1) == '0') {
                    lista.add(Integer.parseInt(String.valueOf(valoresUsuario.charAt(i))+valoresUsuario.charAt(i + 1)));
                    i++;
                    continue;
                }
                lista.add(Integer.parseInt(String.valueOf(valoresUsuario.charAt(i))));
            }
        }
        System.out.println(lista);
        String metodologiaRecomendada = servicioTest.guardarValoresUsuario(resultadoUsuario.getNombreUsuario(),lista);
        return new ResponseEntity<>(metodologiaRecomendada, HttpStatus.OK);
    }

}
