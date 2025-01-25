package services;


import java.util.List;

import entities.Etudiant;

public interface EtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
    void deleteEtudiant(Long id);
}