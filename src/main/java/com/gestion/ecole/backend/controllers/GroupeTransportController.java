package com.gestion.ecole.backend.controllers;


import com.gestion.ecole.backend.models.gestionTransport.GroupeTransport;
import com.gestion.ecole.backend.service.gestionEleve.GroupeTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes_transport/")
public class GroupeTransportController {

    @Autowired
    private GroupeTransportService groupeTransportService;

    @PostMapping("create")
    public ResponseEntity<GroupeTransport> create(@RequestBody GroupeTransport groupeTransport){
        return new ResponseEntity<>(groupeTransportService.save(groupeTransport), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<GroupeTransport> update(@RequestBody GroupeTransport groupeTransport,@PathVariable("id") int id) throws Exception {
        GroupeTransport groupeTransport1 = groupeTransportService.update(groupeTransport, id);
        return ResponseEntity.accepted().body(groupeTransport1);
    }

    @GetMapping("all")
    public ResponseEntity<List<GroupeTransport>> findAll(){
        return ResponseEntity.ok(groupeTransportService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<GroupeTransport> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(groupeTransportService.findById(id));
    }

    @GetMapping("surnom/{surnom}")
    public ResponseEntity<GroupeTransport> findBySurnom(@PathVariable String surnom){
        return ResponseEntity.ok(groupeTransportService.findBySurnom(surnom));
    }

}
