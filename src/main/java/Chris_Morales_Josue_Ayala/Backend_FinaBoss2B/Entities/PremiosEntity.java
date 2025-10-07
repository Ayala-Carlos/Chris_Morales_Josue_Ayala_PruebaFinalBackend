package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter
@ToString @EqualsAndHashCode
@Table(name= "PREMIOS")
public class PremiosEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PREMIOS")
        @SequenceGenerator(name = "SEQ_PREMIOS", sequenceName = "SEQ_PREMIOS", allocationSize = 1)
        @Column(name = "ID_PREMIO")
        private long idPremio;

        @Column(name = "NOMBRE_PREMIO")
        private String nommbrePremio;

        @Column(name = "CATEGORIA")
        private String categoria;

        @Column(name = "ANO_PREMIO")
        private Long anoPremio;

        @Column(name = "RESULTADO")
        private String resultado;

        @Column(name = "FECHA_REGISTRO")
        private Date fechaRegistro;

        @ManyToOne
        @JoinColumn(name = "ID_PELICULA", referencedColumnName = "ID_PELICULA")
        private PeliculasEntity pelicula;
}
