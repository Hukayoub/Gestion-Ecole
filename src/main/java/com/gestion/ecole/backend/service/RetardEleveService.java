package com.gestion.ecole.backend.service;

import com.gestion.ecole.backend.models.gestionEleve.RetardEleve;

import java.util.List;

public interface RetardEleveService {

    RetardEleve save(RetardEleve retardEleve);

    RetardEleve update(RetardEleve retardEleve,int id) throws Exception;

    List<RetardEleve> findAll();

    RetardEleve findById(int id) throws Exception;

}
