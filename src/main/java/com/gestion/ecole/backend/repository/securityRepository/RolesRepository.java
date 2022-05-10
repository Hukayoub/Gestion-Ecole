package com.gestion.ecole.backend.repository.securityRepository;

import com.gestion.ecole.backend.models.securityModels.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Roles findByRoleName(String role);
}
