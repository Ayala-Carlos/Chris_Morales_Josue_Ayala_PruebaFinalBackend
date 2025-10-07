package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Models.DTO;

import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Entities.PeliculasEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString @EqualsAndHashCode
public class PremiosDTO {

    private Long idPremio;

    private String nombrePremio;

    private String categoria;

    private Long anoPremio;

    private String resultado;

    private Date fechaRegistro;

    private PeliculasEntity pelicula;
}
