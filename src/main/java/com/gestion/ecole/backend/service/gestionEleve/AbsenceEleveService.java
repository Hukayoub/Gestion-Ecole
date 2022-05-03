package com.gestion.ecole.backend.service.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.AbsenceEleve;
import com.gestion.ecole.backend.models.gestionEleve.Eleve;

import java.util.List;

public interface AbsenceEleveService {

    AbsenceEleve save(AbsenceEleve absenceEleve);

    AbsenceEleve update(AbsenceEleve absenceEleve,int id) throws Exception;

    List<AbsenceEleve> findAll();

    AbsenceEleve findById(int id) throws Exception;

}
