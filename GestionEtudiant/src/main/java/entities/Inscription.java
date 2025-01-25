package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    private String semestre;
}