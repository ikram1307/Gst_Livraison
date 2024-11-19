package org.example.msutilisateur.Service;

import org.example.msutilisateur.Entity.Utilisateur;
import org.example.msutilisateur.Repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class UtilisateurServiceImp implements UtilisateurService{
    @Autowired
    private UtilisateurRepo utilisateurRepository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur updatedUtilisateur) {
        return utilisateurRepository.findById(id)
                .map(utilisateur -> {
                    utilisateur.setNom(updatedUtilisateur.getNom());
                    utilisateur.setEmail(updatedUtilisateur.getEmail());
                    utilisateur.setAdresse(updatedUtilisateur.getAdresse());
                    utilisateur.setTelephone(updatedUtilisateur.getTelephone());
                    utilisateur.setRole(updatedUtilisateur.getRole());
                    return utilisateurRepository.save(utilisateur);
                }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

}
