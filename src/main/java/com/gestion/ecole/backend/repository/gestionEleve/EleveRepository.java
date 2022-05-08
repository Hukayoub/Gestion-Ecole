package com.gestion.ecole.backend.repository.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve,Integer> {

    Eleve findByCin(String cin);

    Eleve findByCne(String cne);

    Eleve findByNomAndPrenom(String nom,String prenom);
}
