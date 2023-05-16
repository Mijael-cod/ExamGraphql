package upeu.edu.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.libro.entity.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
}
