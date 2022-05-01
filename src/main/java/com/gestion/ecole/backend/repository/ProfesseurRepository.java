package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Integer> {

    Professeur findByNomAndPrenom(String nom,String prenom);

}
