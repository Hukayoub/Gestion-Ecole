package com.gestion.ecole.backend.repository.gestionProfesseur;

import com.gestion.ecole.backend.models.gestionProfesseur.RetardProfesseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetardProfesseurRepository extends JpaRepository<RetardProfesseur,Integer> {
}
