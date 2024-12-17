package org.example.mspaiement;

import org.example.mspaiement.Repository.FactureRepository;
import org.example.mspaiement.Repository.PaiementRepository;
import org.example.mspaiement.Entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
@EnableFeignClients

@SpringBootApplication
public class MsPaiementApplication {


    public static void main(String[] args) {
        SpringApplication.run(MsPaiementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PaiementRepository paiementRepository, FactureRepository factureRepository) {
        return args -> {
            Paiement paiement1 = paiementRepository.save(Paiement.builder()
                    .montant(299.99)
                    .datePaiement(LocalDate.now())
                    .methodePaiement("Carte")
                    .commandeId(1L)
                    .build());

            Paiement paiement2 = paiementRepository.save(Paiement.builder()
                    .montant(499.99)
                    .datePaiement(LocalDate.now())
                    .methodePaiement("PayPal")
                    .commandeId(2L)
                    .build());

            factureRepository.save(Facture.builder()
                    .dateFacture(LocalDate.now())
                    .details("Facture pour Paiement 1")
                    .paiement(paiement1)
                    .build());

            factureRepository.save(Facture.builder()
                    .dateFacture(LocalDate.now())
                    .details("Facture pour Paiement 2")
                    .paiement(paiement2)
                    .build());
        };
    }
}
