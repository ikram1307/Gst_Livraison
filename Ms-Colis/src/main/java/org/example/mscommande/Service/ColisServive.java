package org.example.mscommande.Service;

import org.example.mscommande.Entity.Colis;
import org.example.mscommande.Entity.Statut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commandeServive")
public interface ColisServive {
    Colis createCommande(Colis commande);

    List<Colis> getAllCommandes();

    Colis getCommandeById(Long id);

    Colis updateCommandeStatus(Long id, Statut status);

    void deleteCommande(Long id);
}
