package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Service;

import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Entities.PremiosEntity;
import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Models.DTO.PremiosDTO;
import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Repositories.PremiosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PremiosService {
    @Autowired
    private PremiosRepository repo;

    private PremiosDTO convertirDTO(PremiosEntity objEntity){
        PremiosDTO dto = new PremiosDTO();
        dto.setIdPremio(objEntity.getIdPremio());
        dto.setNombrePremio(objEntity.getNommbrePremio());
        dto.setCategoria(objEntity.getCategoria());
        dto.setAnoPremio(objEntity.getAnoPremio());
        dto.setResultado(objEntity.getResultado());
        dto.setFechaRegistro(objEntity.getFechaRegistro());
        dto.setPelicula(objEntity.getPelicula());
        return dto;
    }

    private PremiosEntity convertirAEntity(PremiosDTO objDto){
        PremiosEntity objEntity = new PremiosEntity();
        objEntity.setIdPremio(objDto.getIdPremio());
        objEntity.setNommbrePremio(objDto.getNombrePremio());
        objEntity.setCategoria(objDto.getCategoria());
        objEntity.setResultado(objDto.getResultado());
        objEntity.setFechaRegistro(objDto.getFechaRegistro());
        objEntity.setPelicula(objDto.getPelicula());

        return objEntity;
    }

    //Obtener Premios
    public List <PremiosDTO>obtenerPremios(){
        List<PremiosEntity>premios = repo.findAll();
        return premios.stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    //Insertar
    public PremiosDTO ingresarPremio(PremiosDTO premiodto){
        PremiosEntity nuevoPremio = convertirAEntity(premiodto);
        PremiosEntity premioguardado = repo.save(nuevoPremio);
        return convertirDTO(premioguardado);
    }

    //Actualizar
    public PremiosDTO actualizarPremio(Long id, PremiosDTO premiosDTO){
        Optional<PremiosEntity>premioexistente = repo.findById(id);

        if (premioexistente.isPresent()){
            PremiosEntity premio = premioexistente.get();
            premio.setNommbrePremio(premiosDTO.getNombrePremio());
            premio.setCategoria(premiosDTO.getCategoria());
            premio.setAnoPremio(premiosDTO.getAnoPremio());
            premio.setResultado(premiosDTO.getResultado());
            premio.setFechaRegistro(premiosDTO.getFechaRegistro());
            premio.setPelicula(premiosDTO.getPelicula());

            PremiosEntity premioact = repo.save(premio);

            return convertirDTO(premioact);
        }
        else {
            log.error("Premio no encontrado");
            return null;
        }
    }

    //Eliminar
    public boolean eliminarPremio(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }else{
            log.error("No se encontro el id de premio para eliminar");
            return false;
        }
    }
}
