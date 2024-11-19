package org.example.msutilisateur.Web;

import org.example.msutilisateur.Entity.Utilisateur;
import org.example.msutilisateur.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/utilisateur")
@RestController
public class UtilisateurController {

        @Autowired
        private UtilisateurService utilisateurService;

        @PostMapping
        public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
            return ResponseEntity.ok(utilisateurService.createUtilisateur(utilisateur));
        }

        @GetMapping
        public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
            return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
            return utilisateurService.getUtilisateurById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur updatedUtilisateur) {
            return ResponseEntity.ok(utilisateurService.updateUtilisateur(id, updatedUtilisateur));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
            utilisateurService.deleteUtilisateur(id);
            return ResponseEntity.noContent().build();
        }
}
