package com.gestion.ecole.backend.models.gestionEleve;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "classe",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AnneeScolaire> anneeScolaires;

    @ManyToOne()
    @JoinColumn(name = "niveau_id")
    @JsonIgnore
    private Niveau niveau;

    @ManyToOne()
    @JoinColumn(name = "emploi_temps_id")
    @JsonIgnore
    private EmploiTemps emploiTemps;
}
