package com.gestion.ecole.backend.repository.gestionTransport;

import com.gestion.ecole.backend.models.gestionTransport.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
}
