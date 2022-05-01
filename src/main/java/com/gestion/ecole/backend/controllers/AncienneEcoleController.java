package com.gestion.ecole.backend.controllers;

import com.gestion.ecole.backend.models.gestionEleve.AncienneEcole;
import com.gestion.ecole.backend.service.AncienneEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ancienne_ecole/")
public class AncienneEcoleController {

    @Autowired
    private AncienneEcoleService ancienneEcoleService;

    @PostMapping("create")
    public ResponseEntity<AncienneEcole> create(@RequestBody AncienneEcole ancienneEcole){
        return new ResponseEntity<>(ancienneEcoleService.save(ancienneEcole), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<AncienneEcole> update(@RequestBody AncienneEcole ancienneEcole,@PathVariable("id") int id) throws Exception {
        AncienneEcole ecole = ancienneEcoleService.update(ancienneEcole,id);
        return ResponseEntity.accepted().body(ecole);
    }

    @GetMapping("all")
    public ResponseEntity<List<AncienneEcole>> findAll(){
        return ResponseEntity.ok(ancienneEcoleService.findAll());
    }


    @GetMapping("id/{id}")
    public ResponseEntity<AncienneEcole> findById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(ancienneEcoleService.findById(id));
    }
}
