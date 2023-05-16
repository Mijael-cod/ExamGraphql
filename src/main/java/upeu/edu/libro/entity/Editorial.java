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
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ide;

    @Column(name = "nombre_editorial")
    private String nombre_e;

    @Column(name = "pais_editorial")
    private String pais_e;

    @OneToMany(mappedBy = "editorial")
    private Set<Libro> libros;
}
