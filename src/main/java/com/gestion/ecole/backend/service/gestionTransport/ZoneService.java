package com.gestion.ecole.backend.service.gestionTransport;

import com.gestion.ecole.backend.dto.ZoneDto;

import java.util.List;

public interface ZoneService {

    ZoneDto save(ZoneDto zoneDto);

    ZoneDto update(ZoneDto zoneDto,int id) throws Exception;

    List<ZoneDto> findAll();

    ZoneDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
