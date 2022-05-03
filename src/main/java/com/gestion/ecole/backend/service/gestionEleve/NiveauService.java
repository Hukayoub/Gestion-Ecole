package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Matiere;
import com.gestion.ecole.backend.models.gestionEleve.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau save(Niveau niveau);

    Niveau update(Niveau niveau,int id) throws Exception;

    List<Niveau> findAll();

    Niveau findById(int id) throws Exception;

}
