package com.gestion.ecole.backend.models.gestionEleve;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.ecole.backend.models.gestionProfesseur.AbsenceProfesseur;
import com.gestion.ecole.backend.models.gestionProfesseur.RetardProfesseur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "emploi_temps_id")
    private EmploiTemps emploiTemps;

    @OneToMany(mappedBy = "professeur")
    private List<AbsenceProfesseur> absenceProfesseurs;

    @OneToMany(mappedBy = "professeur")
    private List<RetardProfesseur> retardProfesseurs;
}
