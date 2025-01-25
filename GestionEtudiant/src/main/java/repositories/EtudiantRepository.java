package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}