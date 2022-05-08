package com.gestion.ecole.backend.service.gestionPaiement.Impl;

import com.gestion.ecole.backend.dto.ReglementDto;
import com.gestion.ecole.backend.models.gestionPaiement.Reglement;
import com.gestion.ecole.backend.repository.gestionPaiement.ReglementRepository;
import com.gestion.ecole.backend.service.gestionPaiement.ReglementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReglementServiceImpl implements ReglementService {


    private ReglementRepository reglementRepository;

    private ModelMapper modelMapper;

    @Autowired
    public ReglementServiceImpl(ReglementRepository reglementRepository, ModelMapper modelMapper) {
        this.reglementRepository = reglementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReglementDto save(ReglementDto reglementDto) {
        Reglement reglement = modelMapper.map(reglementDto,Reglement.class);
        Reglement saved = reglementRepository.save(reglement);
        return modelMapper.map(saved,ReglementDto.class);
    }

    @Override
    public ReglementDto update(ReglementDto reglementDto, int id) throws Exception {
        Optional<Reglement> reglement = reglementRepository.findById(id);
        if (reglement.isPresent()){
            Reglement reglement1 = modelMapper.map(reglementDto,Reglement.class);
            reglement1.setId(id);
            Reglement updated = reglementRepository.save(reglement1);
            return modelMapper.map(updated,ReglementDto.class);
        }else
            throw new Exception("Fail to update data of Reglement");
    }

    @Override
    public List<ReglementDto> findAll() {
        return reglementRepository.findAll()
                .stream()
                .map(reglement -> modelMapper.map(reglement,ReglementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReglementDto findById(int id) throws Exception {
        Reglement  reglement = reglementRepository.findById(id)
                .orElseThrow(() -> new Exception("Fail to get data of Reglement"));
        return modelMapper.map(reglement,ReglementDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Reglement> reglement = reglementRepository.findById(id);
        if (reglement.isPresent()){
            reglementRepository.deleteById(id);
        }else
            throw new Exception("Fail to delete Reglement");
    }
}
