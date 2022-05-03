package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Matiere;
import com.gestion.ecole.backend.models.gestionEleve.Parent;

import java.util.List;

public interface ParentService {

    Parent save(Parent parent);

    Parent update(Parent parent,int id) throws Exception;

    List<Parent> findAll();

    Parent findById(int id) throws Exception;

    Parent findByNomAndPrenom(String  nom,String prenom);

    Parent findByCin(String cin);
}
