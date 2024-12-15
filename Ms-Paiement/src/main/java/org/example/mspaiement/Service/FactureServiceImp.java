package org.example.mspaiement.Service;

import org.example.mspaiement.Entity.Facture;
import org.example.mspaiement.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImp implements FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Override
    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}
