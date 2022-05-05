package com.gestion.ecole.backend.controllers.gestionTransport;

import com.gestion.ecole.backend.dto.ProgrammeTransportDto;
import com.gestion.ecole.backend.service.gestionTransport.ProgrammeTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programme_transport/")
public class ProgrammeTransportController {

    @Autowired
    private ProgrammeTransportService programmeTransportService;


    @PostMapping("")
    public ResponseEntity<ProgrammeTransportDto> create(@RequestBody ProgrammeTransportDto transportDto){
        return new ResponseEntity<>(programmeTransportService.save(transportDto), HttpStatus.CREATED);
    }
    @PutMapping("update/id/{id}")
    public ResponseEntity<ProgrammeTransportDto> update(@RequestBody ProgrammeTransportDto transportDto,@PathVariable int id) throws Exception{
        ProgrammeTransportDto dto = programmeTransportService.update(transportDto,id);
        return ResponseEntity.accepted().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<ProgrammeTransportDto>> findAll(){
        return ResponseEntity.ok(programmeTransportService.findAll());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<ProgrammeTransportDto> findById(@PathVariable int id) throws Exception{
        ProgrammeTransportDto dto = programmeTransportService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
        programmeTransportService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
