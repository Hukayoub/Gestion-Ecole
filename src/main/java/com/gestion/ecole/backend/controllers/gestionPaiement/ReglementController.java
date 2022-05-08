package com.gestion.ecole.backend.controllers.gestionPaiement;

import com.gestion.ecole.backend.dto.ReglementDto;
import com.gestion.ecole.backend.dto.RetardProfesseurDto;
import com.gestion.ecole.backend.service.gestionPaiement.ReglementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reglement/")
public class ReglementController {

    @Autowired
    private ReglementService reglementService;

    @PostMapping("")
    public ResponseEntity<ReglementDto> create(@RequestBody ReglementDto reglementDto){
        return new ResponseEntity<>(reglementService.save(reglementDto), HttpStatus.CREATED);
    }

    @PutMapping("update/id/{id}")
    public ResponseEntity<ReglementDto> update(@RequestBody ReglementDto reglementDto,@PathVariable("id") int id) throws Exception {
        ReglementDto reglementDto1 = reglementService.update(reglementDto,id);
        return ResponseEntity.accepted().body(reglementDto1);
    }

    @GetMapping("all")
    public ResponseEntity<List<ReglementDto>> findAll(){
        return ResponseEntity.ok(reglementService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ReglementDto> findById(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(reglementService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception {
        reglementService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
