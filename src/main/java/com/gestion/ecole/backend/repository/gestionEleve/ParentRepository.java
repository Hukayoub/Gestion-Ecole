package com.gestion.ecole.backend.repository.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {

    Parent findByNomAndPrenom(String nom,String prenom);

    Parent findByCin(String cin);
}
