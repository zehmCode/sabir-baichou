package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}