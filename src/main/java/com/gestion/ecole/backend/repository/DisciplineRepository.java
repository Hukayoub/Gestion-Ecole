package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Integer> {

    Discipline findByNom(String nom);
}
