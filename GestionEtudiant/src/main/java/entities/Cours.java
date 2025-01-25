package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private int credits;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;
}