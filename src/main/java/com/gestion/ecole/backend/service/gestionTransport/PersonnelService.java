package com.gestion.ecole.backend.service.gestionTransport;

import com.gestion.ecole.backend.dto.PersonnelDto;

import java.util.List;

public interface PersonnelService {

    PersonnelDto save(PersonnelDto personnelDto);

    PersonnelDto update(PersonnelDto personnelDto,int id) throws Exception;

    List<PersonnelDto> findAll();

    PersonnelDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
