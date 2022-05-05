package com.gestion.ecole.backend.controllers.gestionTransport;

import com.gestion.ecole.backend.dto.BusDto;

import com.gestion.ecole.backend.service.gestionTransport.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus/")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("")
    public ResponseEntity<BusDto> create(@RequestBody BusDto busDto){
        return new ResponseEntity<>(busService.save(busDto), HttpStatus.CREATED);
    }
    @PutMapping("update/id/{id}")
    public ResponseEntity<BusDto> update(@RequestBody BusDto busDto,@PathVariable int id) throws Exception{
        BusDto dto = busService.update(busDto,id);
        return ResponseEntity.accepted().body(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<BusDto>> findAll(){
        return ResponseEntity.ok(busService.findAll());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<BusDto> findById(@PathVariable int id) throws Exception{
        BusDto dto = busService.findById(id);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception{
        busService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
