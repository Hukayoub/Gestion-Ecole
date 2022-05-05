package com.gestion.ecole.backend.models.gestionTransport;

import com.gestion.ecole.backend.models.gestionEleve.Eleve;
import com.gestion.ecole.backend.models.gestionTransport.ProgrammeTransport;
import com.gestion.ecole.backend.models.gestionTransport.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groupe_transport")
@AllArgsConstructor
@NoArgsConstructor
public class GroupeTransport {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String surnom;

    @ManyToMany
    @JoinTable(name = "groupe_transport_eleves",
            joinColumns = {@JoinColumn(name = "groupe_transport_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    private List<Eleve> eleves_transport;

    @OneToOne(mappedBy = "groupeTransport")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "programme_transport_id")
    private ProgrammeTransport programmeTransport;
}
