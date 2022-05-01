package com.gestion.ecole.backend.service;

import com.gestion.ecole.backend.models.gestionEleve.GroupeTransport;

import java.util.List;

public interface GroupeTransportService {

    GroupeTransport save(GroupeTransport absenceEleve);

    GroupeTransport update(GroupeTransport absenceEleve,int id) throws Exception;

    List<GroupeTransport> findAll();

    GroupeTransport findById(int id) throws Exception;

    GroupeTransport findBySurnom(String surnom);
}
