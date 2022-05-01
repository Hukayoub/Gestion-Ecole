package com.gestion.ecole.backend.service;

import com.gestion.ecole.backend.models.gestionEleve.Controle;

import java.util.List;

public interface ControleService {

    Controle save(Controle controle);

    Controle update(Controle controle,int id) throws Exception;

    List<Controle> findAll();

    Controle findById(int id) throws Exception;

    Controle findByLibelle(String libelle);
}
