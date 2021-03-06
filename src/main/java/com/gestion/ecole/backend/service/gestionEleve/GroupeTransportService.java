package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionTransport.GroupeTransport;

import java.util.List;

public interface GroupeTransportService {

    GroupeTransport save(GroupeTransport groupeTransport);

    GroupeTransport update(GroupeTransport groupeTransport,int id) throws Exception;

    List<GroupeTransport> findAll();

    GroupeTransport findById(int id) throws Exception;

    GroupeTransport findBySurnom(String surnom);
}
