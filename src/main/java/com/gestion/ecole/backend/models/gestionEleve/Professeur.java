package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "professeur")
@AllArgsConstructor
@NoArgsConstructor
public class Professeur {

    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String prenom;

    private char sexe;

    private Date date_naissance;

    private String lieu_naissance;

    private String telephone;

    private String fix;

    private String adresse;

    @ManyToOne
    @JoinColumn(name = "emploi_temps_id")
    private EmploiTemps emploiTemps;
}
