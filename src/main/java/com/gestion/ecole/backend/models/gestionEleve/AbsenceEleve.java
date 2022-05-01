package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "absence_eleve")
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceEleve {

    @Id
    @GeneratedValue
    private int id;

    private Time heure_debut;

    private Time heure_fin;

    private Date date_retard;

    private String motif;

    @ManyToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "eleve_id")
    private Eleve eleveAbsence;
}
