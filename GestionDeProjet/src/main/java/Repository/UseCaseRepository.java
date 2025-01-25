package Repository;
import Entities.UseCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UseCaseRepository extends JpaRepository<UseCase, Long> {

}
