package org.example.mscommande;

import org.example.mscommande.Entity.Colis;
import org.example.mscommande.Entity.Statut;
import org.example.mscommande.Repository.ColisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication

public class MsColisApplication {
    @Autowired
    ColisRepo commandeRepo;

    public static void main(String[] args) {
        SpringApplication.run(MsColisApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ColisRepo commandeRepo) {
        return args -> {
            commandeRepo.save(Colis.builder()
                    .reference("HG100001")
                    .prixTotal(299.99)
                    .dateCommande(LocalDateTime.now())
                    .status(Statut.En_attente) // Example status
                    .build());

            commandeRepo.save(Colis.builder()
                    .reference("HG100002")
                    .prixTotal(499.99)
                    .dateCommande(LocalDateTime.now())
                    .status(Statut.En_cours)
                    .build());
        };
    }

}
