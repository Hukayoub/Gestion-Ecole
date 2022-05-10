package com.gestion.ecole.backend.repository.securityRepository;

import com.gestion.ecole.backend.models.securityModels.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Utilisateur findByUsername(String username);
}
