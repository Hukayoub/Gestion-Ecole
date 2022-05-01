package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Eleve {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private Date dateNaissance;

    private String lieuNaissance;

    private char sexe;

    private String photo;

    private String cin;

    @Column(nullable = false)
    private String cne;

    @ManyToMany(mappedBy = "eleves")
    private List<Parent> parents;


    @OneToOne(mappedBy = "eleve",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AncienneEcole ancienneEcole;

    @ManyToMany(mappedBy = "eleves_transport")
    private List<GroupeTransport> groupeTransports;

    @ManyToMany(mappedBy = "eleves_cantine")
    private List<GroupeCantine> groupeCantine;

    @OneToMany(mappedBy = "eleveAbsence")
    private List<AbsenceEleve> absenceEleves;

    @OneToMany(mappedBy = "eleveRetard")
    private List<RetardEleve> retardEleves;

    @ManyToMany(mappedBy = "elevesControles")
    private List<Controle> controles;

    @OneToMany(mappedBy = "eleve",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AnneeScolaire> anneeScolaires;
}
