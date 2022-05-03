package com.gestion.ecole.backend.service.gestionProfesseur;

import com.gestion.ecole.backend.dto.AbsenceProfesseurDto;
import com.gestion.ecole.backend.dto.RetardProfesseurDto;

import java.util.List;

public interface RetardProfesseurService {

    RetardProfesseurDto save(RetardProfesseurDto retardProfesseurDto);

    RetardProfesseurDto update(RetardProfesseurDto retardProfesseurDto,int id) throws Exception;

    List<RetardProfesseurDto> findAll();

    RetardProfesseurDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
