package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Integer> {

    Classe findBySurnom(String surnom);
}
