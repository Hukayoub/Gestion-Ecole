package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZoneDto implements Serializable {
    private final int id;
    private final String libelle;
    private final String description;
}
