package com.gestion.ecole.backend.service.gestionPaiement;

import com.gestion.ecole.backend.dto.FraisDto;
import com.gestion.ecole.backend.dto.ReglementDto;

import java.util.List;

public interface ReglementService {

    ReglementDto save(ReglementDto reglementDto);

    ReglementDto update(ReglementDto reglementDto,int id) throws Exception;

    List<ReglementDto> findAll();

    ReglementDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
