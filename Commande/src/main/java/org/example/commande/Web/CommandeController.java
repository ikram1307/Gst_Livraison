package org.example.commande.Web;

import lombok.AllArgsConstructor;
import org.example.commande.Entity.Commande;
import org.example.commande.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@AllArgsConstructor
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.GetCommandeById(id);
        return commande != null ? ResponseEntity.ok(commande) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Commande addCommande(@RequestBody Commande cmd) {
        return commandeService.AddCommande(cmd);
    }

    @PutMapping
    public Commande updateCommande(@RequestBody Commande cmd) {
        return commandeService.UpdateCommande(cmd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Commande> deleteCommande(@PathVariable Long id) {
        Commande commande = commandeService.GetCommandeById(id);
        if (commande != null) {
            commandeService.DeleteCommande(commande);
            return ResponseEntity.ok(commande);
        }
        return ResponseEntity.notFound().build();
    }
}
