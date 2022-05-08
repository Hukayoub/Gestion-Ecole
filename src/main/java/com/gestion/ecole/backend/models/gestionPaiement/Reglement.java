package com.gestion.ecole.backend.models.gestionPaiement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "regelement")
@AllArgsConstructor
@NoArgsConstructor
public class Reglement {

    @Id
    @GeneratedValue
    private int id;

    private double montant_regler;

    private Date date_reglement;

    private String mode_reglement;

    private Date date_echeance;

    private String mois_regler;

    @OneToMany(mappedBy = "regelement")
    private List<Frais> frais;
}
