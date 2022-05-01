package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "classe")
@AllArgsConstructor
@NoArgsConstructor
public class Classe {

    @Id
    @GeneratedValue
    private int id;

    private String surnom;

    @OneToMany(mappedBy = "classe",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AnneeScolaire> anneeScolaires;

    @ManyToOne()
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @ManyToOne()
    @JoinColumn(name = "emploi_temps_id")
    private EmploiTemps emploiTemps;
}
