package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Controller;

import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Models.DTO.PremiosDTO;
import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Service.PremiosService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/premios")
@CrossOrigin
public class PremiosController {

    @Autowired
    private PremiosService premiosService;

    @GetMapping("/obtenerPremios")
    public List<PremiosDTO> obtenerPremios(){
        return premiosService.obtenerPremios();
    }

    @PostMapping("/agregarpremio")
    public ResponseEntity<PremiosDTO>ingresarPremio(@RequestBody PremiosDTO premiodto){
        try{
            PremiosDTO nuevo = premiosService.ingresarPremio(premiodto);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizarpremio/{id}")
    public ResponseEntity<PremiosDTO>actualizarPremio(@PathVariable Long id, @RequestBody PremiosDTO premiodto){
        try{
            PremiosDTO nuevoact = premiosService.actualizarPremio(id, premiodto);
            if (nuevoact != null){
                return new ResponseEntity<>(nuevoact, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarpremio/{id}")
    public ResponseEntity<String>eliminarPremio(@PathVariable Long id){
        try{
            boolean eliminado = premiosService.eliminarPremio(id);
            if (eliminado){
                return new ResponseEntity<>("Eliminado ok", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Premio no encontrado", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar el premio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
