package com.gestion.ecole.backend.models.gestionEleve;

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
}
