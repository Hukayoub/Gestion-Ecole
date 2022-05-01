package com.gestion.ecole.backend.controllers;

import com.gestion.ecole.backend.models.gestionEleve.Controle;
import com.gestion.ecole.backend.repository.ControleRepository;
import com.gestion.ecole.backend.service.ControleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controles/")
public class ControleController {

    @Autowired
    private ControleService controleService;

    @PostMapping("create")
    public ResponseEntity<Controle> create(@RequestBody Controle controle){
        return new ResponseEntity<>(controleService.save(controle), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Controle> update(@RequestBody Controle controle,@PathVariable int id) throws Exception {
        Controle controle1 = controleService.update(controle,id);
        return ResponseEntity.accepted().body(controle1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Controle>> findAll(){
        return ResponseEntity.ok(controleService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Controle> findById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(controleService.findById(id));
    }

    @GetMapping("libelle/{libelle}")
    public ResponseEntity<Controle> findByLibelle(@PathVariable String libelle){
        return ResponseEntity.ok(controleService.findByLibelle(libelle));
    }
}
