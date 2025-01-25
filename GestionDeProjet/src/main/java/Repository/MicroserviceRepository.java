package Repository;
import Entities.Microservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {

}
