package com.gestion.ecole.backend.models.gestionProfesseur;

import com.gestion.ecole.backend.models.gestionEleve.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "absence_professeur")
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceProfesseur {

    @Id
    @GeneratedValue
    private int id;

    private Time heure_debut;

    private Time heure_fin;

    private Date date_absence;

    private String motif;


    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;
}
