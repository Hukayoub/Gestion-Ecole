package com.gestion.ecole.backend.models.gestionPaiement;

import com.gestion.ecole.backend.models.gestionEleve.Niveau;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "frais")
@AllArgsConstructor
@NoArgsConstructor
public class Frais {

    @Id
    @GeneratedValue
    private int id;

    private String type_frais;

    private double frais_1;

    private double frais_2;

    private double frais_3;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "reglement_id")
    private Reglement regelement;
}
