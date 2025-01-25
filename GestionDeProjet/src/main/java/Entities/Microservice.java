package Entities;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Microservice {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Identifiant unique pour chaque microservice
  
	    private String nom; // Nom du microservice
	    private String description; // Description du microservice
	    
	    @ManyToOne
	    @JoinColumn(name = "projet_id", nullable = false)
	    private Projet projet; // Relation avec Projet 
}
