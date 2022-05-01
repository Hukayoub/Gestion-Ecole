package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "emploi_temps")
@AllArgsConstructor
@NoArgsConstructor
public class EmploiTemps {

    @Id
    @GeneratedValue
    private int id;

    private Time heure_debut;

    private Time heure_fin;

    @OneToMany(mappedBy = "emploiTemps")
    private List<Classe> classes;

    @OneToMany(mappedBy = "emploiTemps")
    private List<Professeur> professeurList;
}
