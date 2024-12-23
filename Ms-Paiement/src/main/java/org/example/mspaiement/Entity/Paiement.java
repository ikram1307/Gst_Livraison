package org.example.mspaiement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;

    private LocalDate datePaiement;

    @Column(nullable = false)
    private String methodePaiement; // Carte, PayPal, etc.

    private Long commandeId;

    @OneToOne(mappedBy = "paiement", cascade = CascadeType.ALL) // Relation One-to-One
    @JsonIgnore

    private Facture facture;
}
