package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
public class RetardProfesseurDto implements Serializable {
    private final int id;
    private final Time heure_debut;
    private final Time heure_fin;
    private final Date date_retard;
    private final String motif;
}
