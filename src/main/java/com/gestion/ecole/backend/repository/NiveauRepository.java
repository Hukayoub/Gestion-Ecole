package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Integer> {
}
