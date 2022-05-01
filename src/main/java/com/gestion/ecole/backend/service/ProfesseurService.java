package com.gestion.ecole.backend.service;

import com.gestion.ecole.backend.models.gestionEleve.Professeur;

import java.util.List;

public interface ProfesseurService {

    Professeur save(Professeur professeur);

    Professeur update(Professeur professeur,int id) throws Exception;

    List<Professeur> findAll();

    Professeur findById(int id) throws Exception;

    Professeur findByNomAndPrenom(String nom,String prenom);
}
