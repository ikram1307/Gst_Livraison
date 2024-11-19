package org.example.mscommande.Service;

import org.example.mscommande.Entity.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("commandeServive")
public interface CommandeServive {
    Commande createCommande(Commande commande);

    List<Commande> getAllCommandes();

    Commande getCommandeById(Long id);

    Commande updateCommandeStatus(Long id, String status);

    void deleteCommande(Long id);
}
