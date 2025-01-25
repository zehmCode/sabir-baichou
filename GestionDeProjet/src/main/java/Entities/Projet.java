package Entities;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projets")
public class Projet {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String nom; // Nom du projet

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UseCase> useCases; // Liste des Use Cases associés

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Microservice> microservices; // Liste des microservices associés

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiagrammeDeClasse> diagrammesDeClasse; // Liste des diagrammes de classe associés
}
