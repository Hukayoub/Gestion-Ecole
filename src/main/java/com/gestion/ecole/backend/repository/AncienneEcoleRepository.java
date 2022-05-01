package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.AncienneEcole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncienneEcoleRepository extends JpaRepository<AncienneEcole,Integer> {

}
