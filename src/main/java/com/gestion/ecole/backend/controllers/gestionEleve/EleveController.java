package com.gestion.ecole.backend.controllers.gestionEleve;


import com.gestion.ecole.backend.models.gestionEleve.Eleve;
import com.gestion.ecole.backend.service.gestionEleve.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleves/")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    @PostMapping("create")
    public ResponseEntity<Eleve> create(@RequestBody Eleve eleve){
        return new ResponseEntity<>(eleveService.save(eleve), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Eleve> update(@RequestBody Eleve eleve,@PathVariable("id") int id) throws Exception {
        Eleve eleve1 = eleveService.update(eleve,id);
        return ResponseEntity.accepted().body(eleve1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Eleve>> findAll(){
        return ResponseEntity.ok(eleveService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Eleve> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(eleveService.findById(id));
    }

    @GetMapping("cin/{cin}")
    public ResponseEntity<Eleve> findByCin(@PathVariable("cin") String cin){
        return ResponseEntity.ok(eleveService.findByCin(cin));
    }

    @GetMapping("cne/{cne}")
    public ResponseEntity<Eleve> findByCne(@PathVariable("cne") String cne){
        return ResponseEntity.ok(eleveService.findByCne(cne));
    }

    @GetMapping("nom_prenom/{nom}/{prenom}")
    public ResponseEntity<Eleve> findByNomAndPrenom(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom){
        return ResponseEntity.ok(eleveService.findByNomAndPrenom(nom, prenom));
    }
}
