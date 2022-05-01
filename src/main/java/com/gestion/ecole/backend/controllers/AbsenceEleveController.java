package com.gestion.ecole.backend.controllers;

import com.gestion.ecole.backend.models.gestionEleve.AbsenceEleve;
import com.gestion.ecole.backend.service.AbsenceEleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences_eleves/")
public class AbsenceEleveController {

    @Autowired
    private AbsenceEleveService absenceEleveService;

    @PostMapping("create")
    public ResponseEntity<AbsenceEleve> create(@RequestBody AbsenceEleve absenceEleve){
        return new ResponseEntity<>(absenceEleveService.save(absenceEleve), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<AbsenceEleve> update(@RequestBody AbsenceEleve absenceEleve,@PathVariable("id") int id) throws Exception {
        AbsenceEleve eleve=  absenceEleveService.update(absenceEleve,id);
        return ResponseEntity.accepted().body(eleve);
    }

    @GetMapping("all")
    public ResponseEntity<List<AbsenceEleve>> findAll(){
        return ResponseEntity.ok(absenceEleveService.findAll());
    }


    @GetMapping("id/{id}")
    public ResponseEntity<AbsenceEleve> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(absenceEleveService.findById(id));
    }
}
