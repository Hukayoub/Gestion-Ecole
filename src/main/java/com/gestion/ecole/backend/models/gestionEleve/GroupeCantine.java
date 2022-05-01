package com.gestion.ecole.backend.models.gestionEleve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groupe_cantine")
@AllArgsConstructor
@NoArgsConstructor
public class GroupeCantine {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String surnom;

    @ManyToMany
    @JoinTable(name = "groupe_cantine_eleves",
            joinColumns = {@JoinColumn(name = "groupe_cantine_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    private List<Eleve> eleves_cantine;
}
