package org.example.mspaiement.Repository;

import org.example.mspaiement.Entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
