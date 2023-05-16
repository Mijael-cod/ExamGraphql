package upeu.edu.libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idl;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "paginas")
    private int paginas;

    @Column(name = "edicion")
    private String edicion;

    @ManyToOne
    @JoinColumn(name="ida", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="ide", nullable=false)
    private Editorial editorial;


}
