package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.EmploiTemps;

import java.util.List;

public interface EmploiTempsService {

    EmploiTemps save(EmploiTemps emploiTemps);

    EmploiTemps update(EmploiTemps emploiTemps,int id) throws Exception;

    List<EmploiTemps> findAll();

    EmploiTemps findById(int id) throws Exception;



}
