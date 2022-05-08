package com.gestion.ecole.backend.repository.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.GroupeCantine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeCantineRepository extends JpaRepository<GroupeCantine,Integer> {

    GroupeCantine findBySurnom(String surnom);
}
