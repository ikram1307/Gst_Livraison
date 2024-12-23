package org.example.mspaiement.Service;

import org.example.mspaiement.Client.CommandeFeignClient;
import org.example.mspaiement.DTO.Commande;
import org.example.mspaiement.Entity.Paiement;
import org.example.mspaiement.Repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImp implements PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
    @Autowired
    private CommandeFeignClient commandeFeignClient;

    public Commande getCommandeDetails(Long commandeId) {
        return commandeFeignClient.getCommadeById(commandeId); // Call Microservice B
    }

    public void updateCommandeAfterPaiement(Long commandeId, String newStatus) {
        Commande commande = commandeFeignClient.getCommadeById(commandeId);
        commande.setStatus(newStatus);
        commandeFeignClient.updateCommandeStatus(commandeId, commande); // Update in Microservice B
    }
}