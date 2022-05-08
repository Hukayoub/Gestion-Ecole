package com.gestion.ecole.backend.service.gestionPaiement;

import com.gestion.ecole.backend.dto.BusDto;
import com.gestion.ecole.backend.dto.FraisDto;

import java.util.List;

public interface FraisService {

    FraisDto save(FraisDto fraisDto);

    FraisDto update(FraisDto fraisDto,int id) throws Exception;

    List<FraisDto> findAll();

    FraisDto findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
