package com.gestion.ecole.backend.controllers;


import com.gestion.ecole.backend.models.gestionEleve.Niveau;
import com.gestion.ecole.backend.service.gestionEleve.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    @PostMapping("create")
    public ResponseEntity<Niveau> create(@RequestBody Niveau niveau){
        return new ResponseEntity<>(niveauService.save(niveau), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Niveau> update(@RequestBody Niveau niveau,@PathVariable("id") int id) throws Exception {
        Niveau niveau1 = niveauService.update(niveau, id);
        return ResponseEntity.accepted().body(niveau1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Niveau>> findAll(){
        return ResponseEntity.ok(niveauService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Niveau> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(niveauService.findById(id));
    }
}
