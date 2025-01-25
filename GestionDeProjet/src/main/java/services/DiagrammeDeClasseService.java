package services;
import Entities.DiagrammeDeClasse;
import Repository.DiagrammeDeClasseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagrammeDeClasseService {
	  private final DiagrammeDeClasseRepository repository;

	    public DiagrammeDeClasseService(DiagrammeDeClasseRepository repository) {
	        this.repository = repository;
	    }

	    public List<DiagrammeDeClasse> getAllDiagrammes() {
	        return repository.findAll();
	    }

	    public Optional<DiagrammeDeClasse> getDiagrammeById(Long id) {
	        return repository.findById(id);
	    }

	    public DiagrammeDeClasse saveDiagramme(DiagrammeDeClasse diagramme) {
	        return repository.save(diagramme);
	    }

	    public void deleteDiagramme(Long id) {
	        repository.deleteById(id);
	    }
}
