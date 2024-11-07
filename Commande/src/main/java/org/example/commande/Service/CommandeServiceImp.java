package org.example.commande.Service;

import lombok.AllArgsConstructor;
import org.example.commande.Entity.Commande;
import org.example.commande.Repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CommandeServiceImp implements CommandeService{
    @Autowired
    private CommandeRepo commandeRepo;

    @Override
    public List<Commande> getAllStudents() {
        return commandeRepo.findAll();
    }

    @Override
    public Commande GetCommandeById(Long id) {
        return commandeRepo.findById(id).orElse(null);
    }

    @Override
    public Commande AddCommande(Commande cmd) {
        return commandeRepo.save(cmd);
    }

    @Override
    public Commande UpdateCommande(Commande cmd) {
        return commandeRepo.save(cmd);
    }

    @Override
    public void DeleteCommande(Commande cmd) {
        commandeRepo.delete(cmd);

    }
}
