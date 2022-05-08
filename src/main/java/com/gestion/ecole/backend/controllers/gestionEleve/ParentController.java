package com.gestion.ecole.backend.controllers.gestionEleve;


import com.gestion.ecole.backend.models.gestionEleve.Parent;
import com.gestion.ecole.backend.service.gestionEleve.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents/")
public class ParentController {

    @Autowired
    private ParentService parentService;


    @PostMapping("create")
    public ResponseEntity<Parent> create(@RequestBody Parent parent){
        return new ResponseEntity<>(parentService.save(parent), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Parent> update(@RequestBody Parent parent,@PathVariable("id") int id) throws Exception {
        Parent parent1 = parentService.update(parent, id);
        return ResponseEntity.accepted().body(parent1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Parent>> findAll(){
        return ResponseEntity.ok(parentService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Parent> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(parentService.findById(id));
    }

    @GetMapping("cin/{cin}")
    public ResponseEntity<Parent> findByCin(@PathVariable String cin){
        return ResponseEntity.ok(parentService.findByCin(cin));
    }

    @GetMapping("nom_prenom/{nom}/{prenom}")
    public ResponseEntity<Parent> findByNomAndPrenom(@PathVariable String nom,String prenom){
        return ResponseEntity.ok(parentService.findByNomAndPrenom(nom,prenom));
    }
}
