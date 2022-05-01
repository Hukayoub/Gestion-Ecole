package com.gestion.ecole.backend.controllers;


import com.gestion.ecole.backend.models.gestionEleve.Classe;
import com.gestion.ecole.backend.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes/")
public class ClasseController {

    @Autowired
    private ClasseService classeService;


    @PostMapping("create")
    public ResponseEntity<Classe> create(@RequestBody Classe classe){
        return new ResponseEntity<>(classeService.save(classe), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Classe> update(@RequestBody Classe classe,@PathVariable("id") int id) throws Exception {
        Classe classe1 = classeService.update(classe,id);
        return ResponseEntity.accepted().body(classe1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Classe>> findAll(){
        return ResponseEntity.ok(classeService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Classe> findById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(classeService.findById(id));
    }

    @GetMapping("surnom/{surnom}")
    public ResponseEntity<Classe> findBySurnom(String surnom){
        return ResponseEntity.ok(classeService.findBySurnom(surnom));
    }
}
