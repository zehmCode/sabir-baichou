package Entities;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DiagrammeDeClasse {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour chaque diagramme de classe

    private String nom; // Nom du diagramme de classe
    private String description;

    @ElementCollection
    @CollectionTable(name = "diagramme_attributs", joinColumns = @JoinColumn(name = "diagramme_id"))
    @Column(name = "attribut")
    private List<String> attributs; // Liste des attributs du diagramme

    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet; // Relation avec Projet
}
