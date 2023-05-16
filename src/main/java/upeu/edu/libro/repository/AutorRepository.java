package upeu.edu.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.libro.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
}
