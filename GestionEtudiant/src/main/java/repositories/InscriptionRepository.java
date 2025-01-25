package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}