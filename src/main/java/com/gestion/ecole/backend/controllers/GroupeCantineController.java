package com.gestion.ecole.backend.controllers;

import com.gestion.ecole.backend.models.gestionEleve.GroupeCantine;
import com.gestion.ecole.backend.service.gestionEleve.GroupeCantineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes_cantines/")
public class GroupeCantineController {

    @Autowired
    private GroupeCantineService groupeCantineService;

    @PostMapping("create")
    public ResponseEntity<GroupeCantine> create(@RequestBody GroupeCantine groupeCantine){
        return new ResponseEntity<>(groupeCantineService.save(groupeCantine), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<GroupeCantine> update(@RequestBody GroupeCantine groupeCantine,@PathVariable("id") int id) throws Exception {
        GroupeCantine groupeCantine1 = groupeCantineService.update(groupeCantine, id);
        return ResponseEntity.accepted().body(groupeCantine1);
    }

    @GetMapping("all")
    public ResponseEntity<List<GroupeCantine>> findAll(){
        return ResponseEntity.ok(groupeCantineService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<GroupeCantine> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(groupeCantineService.findById(id));
    }

    @GetMapping("surnom/{surnom}")
    public ResponseEntity<GroupeCantine> findBySurnom(@PathVariable String surnom){
        return ResponseEntity.ok(groupeCantineService.findBySurnom(surnom));
    }
}
