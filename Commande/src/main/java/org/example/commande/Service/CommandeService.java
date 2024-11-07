package org.example.commande.Service;

import org.example.commande.Entity.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommandeService {
    public List<Commande> getAllStudents();
    public Commande GetCommandeById(Long id);
    public Commande AddCommande(Commande cmd);
    public Commande UpdateCommande(Commande cmd);
    public void DeleteCommande(Commande cmd);
}
