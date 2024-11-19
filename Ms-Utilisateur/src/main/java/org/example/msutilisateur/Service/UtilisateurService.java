package org.example.msutilisateur.Service;

import org.example.msutilisateur.Entity.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UtilisateurService {
    Utilisateur createUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> getAllUtilisateurs();

    Optional<Utilisateur> getUtilisateurById(Long id);

    Utilisateur updateUtilisateur(Long id, Utilisateur updatedUtilisateur);

    void deleteUtilisateur(Long id);
}
