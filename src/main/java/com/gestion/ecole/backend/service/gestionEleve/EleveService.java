package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Eleve;

import java.util.List;

public interface EleveService {

    Eleve save(Eleve eleve);

    Eleve update(Eleve eleve,int id) throws Exception;

    List<Eleve> findAll();

    Eleve findById(int id) throws Exception;

    Eleve findByCin(String cin);

    Eleve findByCne(String cne);

    Eleve findByNomAndPrenom(String nom,String prenom);
}
