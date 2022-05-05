package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonnelDto implements Serializable {
    private final int id;
    private final String nom;
    private final String prenom;
    private final Date date_naissance;
    private final String lieu_naissance;
    private final String cin;
    private final String tele;
    private final String adresse;
    private final String type_personnel;
}
