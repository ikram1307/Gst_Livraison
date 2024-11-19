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
    private CommandeServive commandeServive ;

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeServive.createCommande(commande));
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeServive.getAllCommandes());
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeServive.getCommandeById(id);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Commande> updateCommandeStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(commandeServive.updateCommandeStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeServive.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}
