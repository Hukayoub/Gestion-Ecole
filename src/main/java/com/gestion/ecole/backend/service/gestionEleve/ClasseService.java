package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Classe;

import java.util.List;

public interface ClasseService {

    Classe save(Classe classe);

    Classe update(Classe classe,int id) throws Exception;

    List<Classe> findAll();

    Classe findById(int id) throws Exception;

    Classe findBySurnom(String surnom);

}
