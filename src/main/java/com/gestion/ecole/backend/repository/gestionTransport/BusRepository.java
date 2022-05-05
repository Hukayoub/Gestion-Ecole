package com.gestion.ecole.backend.repository.gestionTransport;

import com.gestion.ecole.backend.models.gestionTransport.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {
}
