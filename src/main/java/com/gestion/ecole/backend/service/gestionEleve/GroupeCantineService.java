package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.GroupeCantine;

import java.util.List;

public interface GroupeCantineService {

    GroupeCantine save(GroupeCantine groupeCantine);

    GroupeCantine update(GroupeCantine groupeCantine,int id) throws Exception;

    List<GroupeCantine> findAll();

    GroupeCantine findById(int id) throws Exception;

    GroupeCantine findBySurnom(String surnom);
}
