package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaire;
import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaireKey;

import java.util.List;

public interface AnneeScolaireService {

    AnneeScolaire save(AnneeScolaire anneeScolaire);

    AnneeScolaire update(AnneeScolaire anneeScolaire, AnneeScolaireKey key) throws Exception;

    List<AnneeScolaire> findAll();

    AnneeScolaire findById(AnneeScolaireKey key) throws Exception;


}
