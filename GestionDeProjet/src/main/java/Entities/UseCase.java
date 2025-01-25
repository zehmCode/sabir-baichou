package Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UseCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour chaque Use Case

    private String titre; // Titre du Use Case
    private String description; // Description du Use Case
    
    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet; // Relation avec Projet
}
