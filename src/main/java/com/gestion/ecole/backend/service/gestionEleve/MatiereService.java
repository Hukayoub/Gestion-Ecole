package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Matiere;

import java.util.List;

public interface MatiereService {

    Matiere save(Matiere matiere);

    Matiere update(Matiere matiere,int id) throws Exception;

    List<Matiere> findAll();

    Matiere findById(int id) throws Exception;

    Matiere findByNom(String  nom);
}
