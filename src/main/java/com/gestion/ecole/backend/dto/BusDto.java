package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusDto implements Serializable {
    private final int id;
    private final String matricule;
    private final String numero;
}
