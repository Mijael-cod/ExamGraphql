package upeu.edu.libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ida;

    @Column(name = "nombre_autor")
    private String nombre_a;

    @Column(name = "apellido_autor")
    private String apellido_a;

    @Column(name = "pais_autor")
    private String pais_a;

    @OneToMany(mappedBy = "autor")
    private Set<Libro> libros;

}
