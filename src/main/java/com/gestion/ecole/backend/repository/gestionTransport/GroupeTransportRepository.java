package com.gestion.ecole.backend.repository.gestionTransport;

import com.gestion.ecole.backend.models.gestionTransport.GroupeTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeTransportRepository extends JpaRepository<GroupeTransport,Integer> {

    GroupeTransport findBySurnom(String surnom);
}
