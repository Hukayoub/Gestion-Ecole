package com.gestion.ecole.backend.service.gestionProfesseur;

import com.gestion.ecole.backend.dto.AbsenceProfesseurDto;

import java.util.List;

public interface AbsenceProfesseurService {

     AbsenceProfesseurDto save(AbsenceProfesseurDto absenceProfesseurDto);

    AbsenceProfesseurDto update(AbsenceProfesseurDto absenceProfesseurDto,int id) throws Exception;

    List<AbsenceProfesseurDto> findAll();

    AbsenceProfesseurDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
