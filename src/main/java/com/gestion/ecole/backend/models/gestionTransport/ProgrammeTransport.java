package com.gestion.ecole.backend.models.gestionTransport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "programme_transport")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeTransport {

    @Id
    @GeneratedValue
    private int id;

    private Time heure_depart;

    private Date date;

    @OneToMany(mappedBy = "programmeTransport")
    private List<Personnel> personnels;

    @OneToMany(mappedBy = "programmeTransport")
    private List<Bus> buses;

    @OneToMany(mappedBy = "programmeTransport")
    private List<GroupeTransport> groupeTransports;
}
