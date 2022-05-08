package com.gestion.ecole.backend.controllers.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.Discipline;
import com.gestion.ecole.backend.service.gestionEleve.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines/")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @PostMapping("create")
    public ResponseEntity<Discipline> create(@RequestBody Discipline discipline){
        return new ResponseEntity<>(disciplineService.save(discipline), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<Discipline> update(@RequestBody Discipline discipline,@PathVariable("id") int id) throws Exception {
        Discipline discipline1 = disciplineService.update(discipline,id);
        return ResponseEntity.accepted().body(discipline1);
    }

    @GetMapping("all")
    public ResponseEntity<List<Discipline>> findAll(){
        return ResponseEntity.ok(disciplineService.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Discipline> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(disciplineService.findById(id));
    }

    @GetMapping("nom/{nom}")
    public ResponseEntity<Discipline> findByNom(@PathVariable("nom") String nom){
        return ResponseEntity.ok(disciplineService.findByNom(nom));
    }
}
