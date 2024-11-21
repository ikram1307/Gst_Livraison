package org.example.mscommande.Web;

import org.example.mscommande.Entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.mscommande.Service.CommandeServive;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeServive commandeServive;

    // Create a new Commande
    @PostMapping("/new")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeServive.createCommande(commande));
    }

    // Get all Commandes
    @GetMapping("/list")
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeServive.getAllCommandes());
    }

    // Get a specific Commande by ID
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeServive.getCommandeById(id);
        return ResponseEntity.ok(commande);
    }

    // Update the status of a Commande
    @PutMapping("/{id}/status")
    public ResponseEntity<Commande> updateCommandeStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(commandeServive.updateCommandeStatus(id, status));
    }

    // Delete a Commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
       commandeServive.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}