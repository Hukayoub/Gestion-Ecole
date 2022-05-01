package com.gestion.ecole.backend.controllers;


import com.gestion.ecole.backend.models.gestionEleve.EmploiTemps;
import com.gestion.ecole.backend.service.EmploiTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emploi_temps/")
public class EmploiTempsController {

    @Autowired
    private EmploiTempsService emploiTempsService;

    @PostMapping("create")
    public ResponseEntity<EmploiTemps> create(@RequestBody EmploiTemps emploiTemps){
        return new ResponseEntity<>(emploiTempsService.save(emploiTemps), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<EmploiTemps> update(@RequestBody EmploiTemps emploiTemps,@PathVariable("id") int id) throws Exception {
        EmploiTemps emploiTemps1 = emploiTempsService.update(emploiTemps, id);
        return ResponseEntity.accepted().body(emploiTemps1);
    }

    @GetMapping("all")
    public ResponseEntity<List<EmploiTemps>> findAll(){
        return ResponseEntity.ok(emploiTempsService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<EmploiTemps> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(emploiTempsService.findById(id));
    }
}
