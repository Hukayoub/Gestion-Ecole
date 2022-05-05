package com.gestion.ecole.backend.repository.gestionTransport;

import com.gestion.ecole.backend.models.gestionTransport.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {
}
