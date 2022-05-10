package com.gestion.ecole.backend.controllers.securityControllers;

import com.gestion.ecole.backend.models.securityModels.Roles;
import com.gestion.ecole.backend.models.securityModels.Utilisateur;
import com.gestion.ecole.backend.service.securityService.CompteService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteController {

    private CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> addUser(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(compteService.AddUser(utilisateur), HttpStatus.CREATED);
    }

    @PostMapping("/role")
    public ResponseEntity<Roles> addRole(@RequestBody Roles roles){
        return new ResponseEntity<>(compteService.AddRole(roles),HttpStatus.CREATED);
    }

    @GetMapping("utilisateurs/{username}")
    public ResponseEntity<Utilisateur> findByUsername(@PathVariable("username") String username){
        Utilisateur utilisateur = compteService.getUserByUsername(username);
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("utilisateurs")
    public ResponseEntity<List<Utilisateur>> findAll(){
        return ResponseEntity.ok(compteService.listUsers());
    }

    @PostMapping("/utilisateur_role")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRole userRole){
      compteService.addRoleToUser(userRole.getUsername(), userRole.getRoleName());
        return ResponseEntity.accepted().build();
    }
}
@Data
class UserRole{
    private String username;
    private String roleName;
}