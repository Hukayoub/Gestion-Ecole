package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "discipline")
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {


    @Id
    @GeneratedValue
    private int id;

    private String nom;

    @OneToMany(mappedBy = "discipline")
    private List<Controle> controles;

    @ManyToMany(mappedBy = "disciplines")
    private List<Niveau> niveaus;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}
