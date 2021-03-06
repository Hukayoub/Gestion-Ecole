package com.gestion.ecole.backend.models.gestionEleve;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.ecole.backend.models.gestionTransport.GroupeTransport;
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

    @JsonIgnore
    @ManyToMany(mappedBy = "eleves_transport")
    private List<GroupeTransport> groupeTransports;

    @JsonIgnore
    @ManyToMany(mappedBy = "eleves_cantine")
    private List<GroupeCantine> groupeCantine;

    @OneToMany(mappedBy = "eleveAbsence")
    private List<AbsenceEleve> absenceEleves;

    @JsonIgnore
    @OneToMany(mappedBy = "eleveRetard")
    private List<RetardEleve> retardEleves;

    @ManyToMany(mappedBy = "elevesControles")
    private List<Controle> controles;

    @JsonIgnore
    @OneToMany(mappedBy = "eleve",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AnneeScolaire> anneeScolaires;
}
