package org.example.mscommande;

import org.example.mscommande.Entity.Commande;
import org.example.mscommande.Entity.Statut;
import org.example.mscommande.Repository.CommandeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication

public class MsCommandeApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MsCommandeApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CommandeRepo commandeRepo) {
        return args -> {
            commandeRepo.save(Commande.builder()
                    .reference("HG100001")
                    .prixTotal(299.99)
                    .dateCommande(LocalDateTime.now())
                    .status(Statut.En_attente) // Example status
                    .build());

            commandeRepo.save(Commande.builder()
                    .reference("HG100002")
                    .prixTotal(499.99)
                    .dateCommande(LocalDateTime.now())
                    .status(Statut.En_cours)
                    .build());
        };
    }

}
