package Controller;
import Entities.DiagrammeDeClasse;
import services.DiagrammeDeClasseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagrammes")

public class DiagrammeDeClasseController {
	private final DiagrammeDeClasseService service;

    public DiagrammeDeClasseController(DiagrammeDeClasseService service) {
        this.service = service;
    }

    @GetMapping
    public List<DiagrammeDeClasse> getAllDiagrammes() {
        return service.getAllDiagrammes();
    }

    @GetMapping("/{id}")
    public Optional<DiagrammeDeClasse> getDiagrammeById(@PathVariable Long id) {
        return service.getDiagrammeById(id);
    }

    @PostMapping
    public DiagrammeDeClasse createDiagramme(@RequestBody DiagrammeDeClasse diagramme) {
        return service.saveDiagramme(diagramme);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagramme(@PathVariable Long id) {
        service.deleteDiagramme(id);
    }

}
