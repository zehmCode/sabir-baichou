package services;
import Entities.Projet;
import Repository.ProjetRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {
	 private final ProjetRepository projetRepository;

	    public ProjetService(ProjetRepository projetRepository) {
	        this.projetRepository = projetRepository;
	    }

	    public List<Projet> getAllProjets() {
	        return projetRepository.findAll();
	    }

	    public Optional<Projet> getProjetById(Long id) {
	        return projetRepository.findById(id);
	    }

	    public Projet saveProjet(Projet projet) {
	        return projetRepository.save(projet);
	    }

	    public void deleteProjet(Long id) {
	        projetRepository.deleteById(id);
	    }
}
