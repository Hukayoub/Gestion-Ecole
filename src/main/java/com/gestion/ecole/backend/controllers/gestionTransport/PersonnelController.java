package com.gestion.ecole.backend.controllers.gestionTransport;

import com.gestion.ecole.backend.dto.PersonnelDto;
import com.gestion.ecole.backend.service.gestionTransport.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel/")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @PostMapping("")
    public ResponseEntity<PersonnelDto> create(@RequestBody PersonnelDto personnelDto){
        return new ResponseEntity<>(personnelService.save(personnelDto), HttpStatus.CREATED);
    }
    @PutMapping("update/id/{id}")
    public ResponseEntity<PersonnelDto> update(@RequestBody PersonnelDto personnelDto,@PathVariable int id) throws Exception{
        PersonnelDto dto = personnelService.update(personnelDto,id);
        return ResponseEntity.accepted().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<PersonnelDto>> findAll(){
        return ResponseEntity.ok(personnelService.findAll());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<PersonnelDto> findById(@PathVariable int id) throws Exception{
        PersonnelDto dto = personnelService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
        personnelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
