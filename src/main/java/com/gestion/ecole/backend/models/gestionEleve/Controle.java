package com.gestion.ecole.backend.models.gestionEleve;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Controle {

    @Id
    @GeneratedValue
    private int id;

    private String libelle;

    private Date date_controle;

    private Time duree_controle;

    private String periode;

    @ManyToMany
    @JoinTable(name = "controles_eleves",
            joinColumns = {@JoinColumn(name = "controle_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    @JsonIgnore
    private List<Eleve> elevesControles;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonIgnore
    private Discipline discipline;
}
