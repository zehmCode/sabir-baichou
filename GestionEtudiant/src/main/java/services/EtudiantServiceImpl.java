package services;

import java.util.List;

import org.springframework.stereotype.Service;

import entities.Etudiant;
import repositories.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}