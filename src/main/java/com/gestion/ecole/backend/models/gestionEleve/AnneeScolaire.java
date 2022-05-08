package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "annee_scolaire")
@AllArgsConstructor
@NoArgsConstructor
public class AnneeScolaire implements Serializable {

    @EmbeddedId
    private AnneeScolaireKey id;

    private Date date_debut;

    private Date date_fin;

    @ManyToOne
    @MapsId("eleveId")
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;


    @ManyToOne
    @MapsId("classeId")
    @JoinColumn(name = "classe_id")
    private Classe classe;


}
