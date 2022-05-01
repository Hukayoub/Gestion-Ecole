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
public class Parent {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private Date dateNaissance;

    private String lieuNaissance;

    @Column(nullable = false)
    private String cin;

    @Column(nullable = false)
    private String type_parent;

    private String telephone;

    private String fix;

    private String adresse;

    @ManyToMany
    @JoinTable(name = "parents_eleves",
            joinColumns = {@JoinColumn(name = "parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    private List<Eleve> eleves;
}
