package com.gestion.ecole.backend.controllers.gestionEleve;

import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaire;
import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaireKey;
import com.gestion.ecole.backend.service.gestionEleve.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annee_scolaire/")
public class AnneeScolaireController {


    @Autowired
    private AnneeScolaireService anneeScolaireService;

    @PostMapping("create")
    public ResponseEntity<AnneeScolaire> create(@RequestBody AnneeScolaire anneeScolaire){
        return new ResponseEntity<>(anneeScolaireService.save(anneeScolaire), HttpStatus.CREATED);
    }

    @PutMapping("update/{classeId}/{eleveId}")
    public ResponseEntity<AnneeScolaire> update(@RequestBody AnneeScolaire anneeScolaire,@PathVariable("classeId") int classeId ,@PathVariable("eleveId") int eleveId) throws Exception {
        AnneeScolaireKey key = new AnneeScolaireKey(classeId,eleveId);
        AnneeScolaire scolaire = anneeScolaireService.update(anneeScolaire,key);
        return ResponseEntity.accepted().body(scolaire);
    }

    @GetMapping("all")
    public ResponseEntity<List<AnneeScolaire>> findAll(){
        return ResponseEntity.ok(anneeScolaireService.findAll());
    }

    @GetMapping("{classeId}/{eleveId}")
    public ResponseEntity<AnneeScolaire> findById(@PathVariable("classeId") int classeId,@PathVariable("eleveId") int eleveId) throws Exception {
        AnneeScolaireKey key = new AnneeScolaireKey(classeId,eleveId);
        return ResponseEntity.ok(anneeScolaireService.findById(key));
    }
}
