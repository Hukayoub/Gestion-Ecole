package com.gestion.ecole.backend.service;

import com.gestion.ecole.backend.models.gestionEleve.AncienneEcole;
import com.gestion.ecole.backend.models.gestionEleve.Eleve;

import java.util.List;

public interface AncienneEcoleService {

    AncienneEcole save(AncienneEcole ancienneEcole);

    AncienneEcole update(AncienneEcole ancienneEcole,int id) throws Exception;

    List<AncienneEcole> findAll();

    AncienneEcole findById(int id) throws Exception;


}
