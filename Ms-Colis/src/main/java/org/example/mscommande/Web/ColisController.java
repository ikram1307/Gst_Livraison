package org.example.mscommande.Web;

import org.example.mscommande.Entity.Colis;
import org.example.mscommande.Entity.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.mscommande.Service.ColisServive;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class ColisController {

    @Autowired
    private ColisServive commandeServive;

    // Create a new Commande
    @PostMapping("/new")
    public ResponseEntity<Colis> createCommande(@RequestBody Colis commande) {
        return ResponseEntity.ok(commandeServive.createCommande(commande));
    }

    // Get all Commandes
    @GetMapping("/list")
    public ResponseEntity<List<Colis>> getAllCommandes() {
        return ResponseEntity.ok(commandeServive.getAllCommandes());
    }

    // Get a specific Commande by ID
    @GetMapping("/{id}")
    public ResponseEntity<Colis> getCommandeById(@PathVariable Long id) {
        Colis commande = commandeServive.getCommandeById(id);
        return ResponseEntity.ok(commande);
    }

    // Update the status of a Commande
    @PutMapping("/{id}/status")
    public ResponseEntity<Colis> updateCommandeStatus(
            @PathVariable Long id,
            @RequestParam Statut status) {
        return ResponseEntity.ok(commandeServive.updateCommandeStatus(id, status));
    }

    // Delete a Commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
       commandeServive.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}