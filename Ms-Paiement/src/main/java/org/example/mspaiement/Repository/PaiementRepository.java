package org.example.mspaiement.Repository;

import org.example.mspaiement.Entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {

}
