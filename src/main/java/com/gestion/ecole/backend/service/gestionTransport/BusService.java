package com.gestion.ecole.backend.service.gestionTransport;

import com.gestion.ecole.backend.dto.AbsenceProfesseurDto;
import com.gestion.ecole.backend.dto.BusDto;

import java.util.List;

public interface BusService {

     BusDto save(BusDto busDto);

    BusDto update(BusDto busDto,int id) throws Exception;

    List<BusDto> findAll();

    BusDto findById(int id) throws Exception;

    void delete(int id) throws Exception;

}
