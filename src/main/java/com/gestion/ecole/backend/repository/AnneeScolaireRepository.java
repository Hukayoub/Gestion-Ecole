package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaire;
import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaireKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, AnneeScolaireKey> {
}
