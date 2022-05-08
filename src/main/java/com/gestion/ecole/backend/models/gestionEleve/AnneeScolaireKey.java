package com.gestion.ecole.backend.models.gestionEleve;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AnneeScolaireKey implements Serializable {

    private static final long serialVersionUID = -3707847537118022716L;


    @Column(name = "classe_id")
    private int classeId;

    @Column(name = "eleve_id")
    private int eleveId;



}
