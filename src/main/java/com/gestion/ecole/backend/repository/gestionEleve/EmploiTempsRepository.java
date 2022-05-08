package com.gestion.ecole.backend.repository.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.EmploiTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiTempsRepository extends JpaRepository<EmploiTemps,Integer> {



}
