package com.gestion.ecole.backend.controllers.gestionPaiement;

import com.gestion.ecole.backend.dto.FraisDto;
import com.gestion.ecole.backend.dto.ReglementDto;
import com.gestion.ecole.backend.service.gestionPaiement.FraisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frais/")
public class FraisController {

    @Autowired
    private FraisService fraisService;

    @PostMapping("")
    public ResponseEntity<FraisDto> create(@RequestBody FraisDto fraisDto){
        return new ResponseEntity<>(fraisService.save(fraisDto), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<FraisDto> update(@RequestBody FraisDto fraisDto,@PathVariable("id") int id) throws Exception {
        FraisDto fraisDto1 = fraisService.update(fraisDto,id);
        return ResponseEntity.accepted().body(fraisDto1);
    }

    @GetMapping("all")
    public ResponseEntity<List<FraisDto>> findAll(){
        return ResponseEntity.ok(fraisService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<FraisDto> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(fraisService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception {
        fraisService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
