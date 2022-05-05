package com.gestion.ecole.backend.models.gestionTransport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zone")
@AllArgsConstructor
@NoArgsConstructor
public class Zone {

    @Id
    @GeneratedValue
    private int id;

    private String libelle;

    private String description;

    @OneToOne
    @JoinColumn(name = "groupe_transport_id")
    private GroupeTransport groupeTransport;
}
