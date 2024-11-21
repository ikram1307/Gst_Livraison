package org.example.msutilisateur;

import org.example.msutilisateur.Entity.Role;
import org.example.msutilisateur.Entity.Utilisateur;
import org.example.msutilisateur.Repository.UtilisateurRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsUtilisateurApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUtilisateurApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(UtilisateurRepo utilisateurRepo) {
        return args -> {
            utilisateurRepo.save(Utilisateur.builder()
                    .nom("Alice")
                    .email("alice@example.com")
                    .adresse("123 Rue A")
                    .telephone("0102030405")
                    .role(Role.Client)
                    .build());
            utilisateurRepo.save(Utilisateur.builder()
                    .nom("AdminUser")
                    .email("admin@example.com")
                    .adresse("Admin HQ")
                    .telephone("0998877665")
                    .role(Role.Admin)
                    .build());

            utilisateurRepo.save(Utilisateur.builder()
                    .nom("John Doe")
                    .email("john.doe@example.com")
                    .adresse("456 Delivery Lane")
                    .telephone("0706060707")
                    .role(Role.Livreur)
                    .build());


        };
    }
}
