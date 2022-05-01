package com.gestion.ecole.backend.repository;

import com.gestion.ecole.backend.models.gestionEleve.Controle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleRepository extends JpaRepository<Controle,Integer> {

    Controle findByLibelle(String libelle);
}
