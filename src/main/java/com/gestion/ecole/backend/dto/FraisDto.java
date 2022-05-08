package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FraisDto implements Serializable {
    private final int id;
    private final String type_frais;
    private final double frais_1;
    private final double frais_2;
    private final double frais_3;
}
