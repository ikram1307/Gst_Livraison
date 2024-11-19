package org.example.mscommande.Repository;

import org.example.mscommande.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepo extends JpaRepository<Commande,Long > {

}
