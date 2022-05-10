package com.gestion.ecole.backend.service.securityService;

import com.gestion.ecole.backend.models.securityModels.Roles;
import com.gestion.ecole.backend.models.securityModels.Utilisateur;
import com.gestion.ecole.backend.repository.securityRepository.RolesRepository;
import com.gestion.ecole.backend.repository.securityRepository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    private UtilisateurRepository utilisateurRepository;

    private RolesRepository rolesRepository;

    private PasswordEncoder passwordEncoder;

    public CompteServiceImpl(UtilisateurRepository utilisateurRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Utilisateur AddUser(Utilisateur utilisateur) {
        String pw = utilisateur.getPassword();
        utilisateur.setPassword(passwordEncoder.encode(pw));
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Roles AddRole(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        Roles roles = rolesRepository.findByRoleName(roleName);
        utilisateur.getRolesList().add(roles);
    }

    @Override
    public Utilisateur getUserByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    @Override
    public List<Utilisateur> listUsers() {
        return utilisateurRepository.findAll();
    }
}
