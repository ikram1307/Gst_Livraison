package org.example.mspaiement.Service;

import org.example.mspaiement.Entity.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {
    Facture createFacture(Facture facture);
    List<Facture> getAllFactures();
    Optional<Facture> getFactureById(Long id);
    void deleteFacture(Long id);
}
