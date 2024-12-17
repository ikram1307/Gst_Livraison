package org.example.mspaiement.Service;

import org.example.mspaiement.Entity.Paiement;

import java.util.List;
import java.util.Optional;

public interface PaiementService {
    Paiement createPaiement(Paiement paiement);
    List<Paiement> getAllPaiements();
    Optional<Paiement> getPaiementById(Long id);
    void deletePaiement(Long id);

}
