package Controller;
import Entities.Projet;
import services.ProjetService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {
	 private final ProjetService service;

	    public ProjetController(ProjetService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Projet> getAllProjets() {
	        return service.getAllProjets();
	    }

	    @GetMapping("/{id}")
	    public Optional<Projet> getProjetById(@PathVariable Long id) {
	        return service.getProjetById(id);
	    }

	    @PostMapping
	    public Projet createProjet(@RequestBody Projet projet) {
	        return service.saveProjet(projet);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProjet(@PathVariable Long id) {
	        service.deleteProjet(id);
	    }

}
