package com.gestion.ecole.backend.service.securityService;

import com.gestion.ecole.backend.models.securityModels.Roles;
import com.gestion.ecole.backend.models.securityModels.Utilisateur;

import java.util.List;

public interface CompteService {

    Utilisateur AddUser(Utilisateur utilisateur);

    Roles AddRole(Roles roles);

    void addRoleToUser(String username,String roleName);

    Utilisateur getUserByUsername(String username);

    List<Utilisateur> listUsers();
}
