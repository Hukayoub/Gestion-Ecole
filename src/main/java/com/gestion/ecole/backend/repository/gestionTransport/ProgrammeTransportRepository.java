package com.gestion.ecole.backend.repository.gestionTransport;

import com.gestion.ecole.backend.models.gestionTransport.ProgrammeTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeTransportRepository extends JpaRepository<ProgrammeTransport,Integer> {
}
