package org.example.mspaiement.Client;

import org.example.mspaiement.DTO.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Ms-Commande") // Replace with Commande Service's base URL or service discovery name
public interface CommandeFeignClient {
    @GetMapping("/paiements")
    List<Commande> getAllCommandes();

    @GetMapping("/paiements/{id}")
    Commande getCommadeById(@PathVariable Long id);

    @PutMapping("/{id}")
    void updateCommandeStatus(@PathVariable("id") Long id, @RequestBody Commande commande);
}
