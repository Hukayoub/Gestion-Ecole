package com.gestion.ecole.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReglementDto implements Serializable {
    private final int id;
    private final double montant_regler;
    private final Date date_reglement;
    private final String mode_reglement;
    private final Date date_echeance;
    private final String mois_regler;
}
