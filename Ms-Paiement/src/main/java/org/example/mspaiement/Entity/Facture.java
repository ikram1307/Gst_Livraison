package org.example.mspaiement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mspaiement.Entity.Paiement;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateFacture;

    private String details;

    @OneToOne
    @JoinColumn(name = "paiement_id", referencedColumnName = "id")
    @JsonIgnore

    private Paiement paiement;
}
