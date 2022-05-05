package com.gestion.ecole.backend.models.gestionTransport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "personnel")
@AllArgsConstructor
@NoArgsConstructor
public class Personnel {

    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String prenom;

    private Date date_naissance;

    private String lieu_naissance;

    private String cin;

    private String tele;

    private String adresse;

    private String type_personnel;


    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


    @ManyToOne
    @JoinColumn(name = "programme_transport_id")
    private ProgrammeTransport programmeTransport;

}
