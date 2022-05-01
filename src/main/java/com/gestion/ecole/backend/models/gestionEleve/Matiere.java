package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "matiere")
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {

    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String couleur;

    @OneToMany(mappedBy = "matiere",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Discipline> disciplines;
}
