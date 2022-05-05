package com.gestion.ecole.backend.service.gestionTransport;

import com.gestion.ecole.backend.dto.ProgrammeTransportDto;

import java.util.List;

public interface ProgrammeTransportService {

    ProgrammeTransportDto save(ProgrammeTransportDto transportDto);

    ProgrammeTransportDto update(ProgrammeTransportDto transportDto,int id) throws Exception;

    List<ProgrammeTransportDto> findAll();

    ProgrammeTransportDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
