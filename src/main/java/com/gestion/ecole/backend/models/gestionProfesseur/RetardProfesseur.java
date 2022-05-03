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
@Table(name = "retard_professeur")
@AllArgsConstructor
@NoArgsConstructor
public class RetardProfesseur {

    @Id
    @GeneratedValue
    private int id;

    private Time heure_debut;

    private Time heure_fin;

    private Date date_retard;

    private String motif;


    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;
}
