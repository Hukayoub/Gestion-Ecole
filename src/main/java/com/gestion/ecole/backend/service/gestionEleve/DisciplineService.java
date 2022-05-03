package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Discipline;

import java.util.List;

public interface DisciplineService {

    Discipline save(Discipline discipline);

    Discipline update(Discipline discipline,int id) throws Exception;

    List<Discipline> findAll();

    Discipline findById(int id) throws Exception;

    Discipline findByNom(String nom);
}
