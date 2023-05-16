package upeu.edu.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.libro.entity.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
