package org.example.mscommande.Service;

import org.example.mscommande.Entity.Colis;
import org.example.mscommande.Entity.Statut;
import org.example.mscommande.Repository.ColisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class ColisServiceImp implements ColisServive {

        @Autowired
        private ColisRepo commandeRepository;

        public Colis createCommande(Colis commande) {
            return commandeRepository.save(commande);
        }

        public List<Colis> getAllCommandes() {
            return commandeRepository.findAll();
        }

        public Colis getCommandeById(Long id) {
            return commandeRepository.findById(id).get();
        }

        public Colis updateCommandeStatus(Long id, Statut status) {
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
