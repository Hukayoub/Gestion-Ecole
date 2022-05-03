package com.gestion.ecole.backend.controllers.gestionProfesseur;

import com.gestion.ecole.backend.dto.AbsenceProfesseurDto;
import com.gestion.ecole.backend.service.gestionProfesseur.AbsenceProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absence_professeur/")
public class AbsenceProfesseurController {

    @Autowired
    private AbsenceProfesseurService absenceProfesseurService;

    @PostMapping("")
    public ResponseEntity<AbsenceProfesseurDto> create(@RequestBody AbsenceProfesseurDto absenceProfesseurDto){
        AbsenceProfesseurDto professeurDto = absenceProfesseurService.save(absenceProfesseurDto);
        return new ResponseEntity<>(professeurDto, HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<AbsenceProfesseurDto> update(@RequestBody AbsenceProfesseurDto absenceProfesseurDto, @PathVariable("id") int id) throws Exception{
        AbsenceProfesseurDto professeurDto = absenceProfesseurService.update(absenceProfesseurDto,id);
        return ResponseEntity.accepted().body(professeurDto);
    }

    @GetMapping("all")
    public ResponseEntity<List<AbsenceProfesseurDto>> findAll(){
        return ResponseEntity.ok(absenceProfesseurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceProfesseurDto> findById(@PathVariable("id") int id) throws Exception{
        return ResponseEntity.ok(absenceProfesseurService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception
    {
        absenceProfesseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
