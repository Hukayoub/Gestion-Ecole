package com.gestion.ecole.backend.controllers.gestionEleve;


import com.gestion.ecole.backend.models.gestionEleve.Professeur;
import com.gestion.ecole.backend.service.gestionEleve.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs/")
public class ProfesseurController {


    @Autowired
    private ProfesseurService professeurService;


    @PostMapping("create")
    public ResponseEntity<Professeur> create(@RequestBody Professeur professeur){
        return new ResponseEntity<>(professeurService.save(professeur), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Professeur> update(@RequestBody Professeur professeur,@PathVariable("id") int id) throws Exception {
        Professeur professeur1 = professeurService.update(professeur, id);
        return ResponseEntity.accepted().body(professeur1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Professeur>> findAll(){
        return ResponseEntity.ok(professeurService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Professeur> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(professeurService.findById(id));
    }


    @GetMapping("nom_prenom/{nom}/{prenom}")
    public ResponseEntity<Professeur> findByNomAndPrenom(@PathVariable String nom,String prenom){
        return ResponseEntity.ok(professeurService.findByNomAndPrenom(nom,prenom));
    }
}
