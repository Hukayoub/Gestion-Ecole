package com.gestion.ecole.backend.controllers.gestionProfesseur;

import com.gestion.ecole.backend.dto.RetardProfesseurDto;
import com.gestion.ecole.backend.service.gestionProfesseur.RetardProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retard_professeur/")
public class RetardProfesseurController {

    @Autowired
    private RetardProfesseurService retardProfesseurService;

    @PostMapping("")
    public ResponseEntity<RetardProfesseurDto> create(@RequestBody RetardProfesseurDto retardProfesseurDto){
        return new ResponseEntity<>(retardProfesseurService.save(retardProfesseurDto), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<RetardProfesseurDto> update(@RequestBody RetardProfesseurDto retardProfesseurDto,@PathVariable("id") int id) throws Exception {
        RetardProfesseurDto professeurDto = retardProfesseurService.update(retardProfesseurDto,id);
        return ResponseEntity.accepted().body(professeurDto);
    }

    @GetMapping("all")
    public ResponseEntity<List<RetardProfesseurDto>> findAll(){
        return ResponseEntity.ok(retardProfesseurService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<RetardProfesseurDto> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(retardProfesseurService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception {
        retardProfesseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
