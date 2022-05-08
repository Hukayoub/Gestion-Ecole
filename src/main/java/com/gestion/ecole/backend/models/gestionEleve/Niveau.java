package com.gestion.ecole.backend.models.gestionEleve;

import com.gestion.ecole.backend.models.gestionPaiement.Frais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "niveau")
@AllArgsConstructor
@NoArgsConstructor
public class Niveau {

    @Id
    @GeneratedValue()
    private int id;

    private String libelle;

    private String option;

    private int capacit_classe;

    @OneToMany(mappedBy = "niveau",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Classe> classes;

    @ManyToMany
    @JoinTable(name = "niveau_discipline",
            joinColumns = {@JoinColumn(name = "niveau_id")},
            inverseJoinColumns = {@JoinColumn(name = "discipline_id")})
    private List<Discipline> disciplines;

    @OneToMany(mappedBy = "niveau")
    private List<Frais> frais;
}
