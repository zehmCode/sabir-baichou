package Repository;
import Entities.DiagrammeDeClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagrammeDeClasseRepository  extends JpaRepository<DiagrammeDeClasse, Long> {

}
