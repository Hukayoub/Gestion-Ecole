package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
public class ProgrammeTransportDto implements Serializable {
    private final int id;
    private final Time heure_depart;
    private final Date date;
}
