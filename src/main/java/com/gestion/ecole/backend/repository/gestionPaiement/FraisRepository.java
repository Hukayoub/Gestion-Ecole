package com.gestion.ecole.backend.repository.gestionPaiement;

import com.gestion.ecole.backend.models.gestionPaiement.Frais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraisRepository extends JpaRepository<Frais,Integer> {
}
