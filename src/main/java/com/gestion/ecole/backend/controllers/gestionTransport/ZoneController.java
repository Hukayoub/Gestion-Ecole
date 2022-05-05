package com.gestion.ecole.backend.controllers.gestionTransport;

import com.gestion.ecole.backend.dto.ZoneDto;
import com.gestion.ecole.backend.models.gestionTransport.Zone;
import com.gestion.ecole.backend.service.gestionTransport.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone/")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping("")
    public ResponseEntity<ZoneDto> create(@RequestBody ZoneDto zoneDto){
        return new ResponseEntity<>(zoneService.save(zoneDto), HttpStatus.CREATED);
    }
    @PutMapping("update/id/{id}")
    public ResponseEntity<ZoneDto> update(@RequestBody ZoneDto zoneDto,@PathVariable int id) throws Exception{
        ZoneDto dto = zoneService.update(zoneDto,id);
        return ResponseEntity.accepted().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<ZoneDto>> findAll(){
        return ResponseEntity.ok(zoneService.findAll());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<ZoneDto> findById(@PathVariable int id) throws Exception{
        ZoneDto dto = zoneService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
        zoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
