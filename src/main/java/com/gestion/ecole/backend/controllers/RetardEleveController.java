package com.gestion.ecole.backend.controllers;


import com.gestion.ecole.backend.models.gestionEleve.RetardEleve;
import com.gestion.ecole.backend.service.gestionEleve.RetardEleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retards_eleves/")
public class RetardEleveController {

    @Autowired
    private RetardEleveService eleveService;


    @PostMapping("create")
    public ResponseEntity<RetardEleve> create(@RequestBody RetardEleve retardEleve){
        return new ResponseEntity<>(eleveService.save(retardEleve), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<RetardEleve> update(@RequestBody RetardEleve retardEleve,@PathVariable("id") int id) throws Exception {
        RetardEleve retardEleve1 = eleveService.update(retardEleve, id);
        return ResponseEntity.accepted().body(retardEleve1);
    }

    @GetMapping("all")
    public ResponseEntity<List<RetardEleve>> findAll(){
        return ResponseEntity.ok(eleveService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<RetardEleve> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(eleveService.findById(id));
    }
}
