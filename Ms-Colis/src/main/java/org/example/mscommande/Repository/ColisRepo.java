package org.example.mscommande.Repository;

import org.example.mscommande.Entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisRepo extends JpaRepository<Colis,Long > {

}
