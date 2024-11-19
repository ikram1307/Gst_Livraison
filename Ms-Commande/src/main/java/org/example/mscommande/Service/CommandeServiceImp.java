package org.example.mscommande.Service;

import org.example.mscommande.Entity.Commande;
import org.example.mscommande.Entity.Statut;
import org.example.mscommande.Repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class CommandeServiceImp implements CommandeServive{

        @Autowired
        private CommandeRepo commandeRepository;

        public Commande createCommande(Commande commande) {
            return commandeRepository.save(commande);
        }

        public List<Commande> getAllCommandes() {
            return commandeRepository.findAll();
        }

        public Commande getCommandeById(Long id) {
            return commandeRepository.findById(id).get();
        }

        public Commande updateCommandeStatus(Long id, String status) {
            return commandeRepository.findById(id)
                    .map(commande -> {
                        commande.setStatus(Statut.En_cours);
                        return commandeRepository.save(commande);
                    }).orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        }

        public void deleteCommande(Long id) {
            commandeRepository.deleteById(id);
        }

}
