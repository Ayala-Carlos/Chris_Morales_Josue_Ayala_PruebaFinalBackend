package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "PELICULAS")
public class PeliculasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PELICULAS")
    @SequenceGenerator(name = "SEQ_PELICULAS", sequenceName = "SEQ_PELICULAS", allocationSize = 1)
    @Column(name = "ID_PELICULA")
    private long idPelicula;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "ANO_ESTRENO")
    private Long anoEstreno;


    @Column(name = "DURACION_MIN")
    private Long duracionMin;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;
}
