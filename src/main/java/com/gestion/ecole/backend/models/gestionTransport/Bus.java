package com.gestion.ecole.backend.models.gestionTransport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue
    private int id;

    private String matricule;

    private String numero;

    @OneToOne(mappedBy = "bus")
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "programme_transport_id")
    private ProgrammeTransport programmeTransport;
}
