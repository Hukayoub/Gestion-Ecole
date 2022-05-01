package com.gestion.ecole.backend.controllers;

import com.gestion.ecole.backend.models.gestionEleve.GroupeTransport;
import com.gestion.ecole.backend.models.gestionEleve.Matiere;
import com.gestion.ecole.backend.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres/")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;


    @PostMapping("create")
    public ResponseEntity<Matiere> create(@RequestBody Matiere matiere){
        return new ResponseEntity<>(matiereService.save(matiere), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Matiere> update(@RequestBody Matiere matiere,@PathVariable("id") int id) throws Exception {
        Matiere matiere1 = matiereService.update(matiere, id);
        return ResponseEntity.accepted().body(matiere1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Matiere>> findAll(){
        return ResponseEntity.ok(matiereService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Matiere> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(matiereService.findById(id));
    }

    @GetMapping("surnom/{surnom}")
    public ResponseEntity<Matiere> findByNom(@PathVariable String nom){
        return ResponseEntity.ok(matiereService.findByNom(nom));
    }
}
