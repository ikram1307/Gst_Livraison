package org.example.mscommande.Client;

import org.example.mscommande.Entity.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "commande-service", url = "http://localhost:8091/commande") // Replace with Commande Service's base URL or service discovery name
public interface CommandeFeignClient {

    @GetMapping("/{id}")
    Commande getCommandeById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    void updateCommandeStatus(@PathVariable("id") Long id, @RequestBody Commande commande);
}
