package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ancienne_ecole")
@AllArgsConstructor
@NoArgsConstructor
public class AncienneEcole {

    @Id
    @GeneratedValue
    private int id;

    private String nom_ecole;

    private String type_ecole;

    private String statut_ecole;

    @OneToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

}
