package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.AbsenceEleve;
import com.gestion.ecole.backend.models.gestionEleve.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceEleveRepository extends JpaRepository<AbsenceEleve,Integer> {

    AbsenceEleve findByEleveAbsence(Eleve eleve);


}
