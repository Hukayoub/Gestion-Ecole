package com.gestion.ecole.backend.service.gestionPaiement.Impl;

import com.gestion.ecole.backend.dto.FraisDto;
import com.gestion.ecole.backend.models.gestionPaiement.Frais;
import com.gestion.ecole.backend.repository.gestionPaiement.FraisRepository;
import com.gestion.ecole.backend.service.gestionPaiement.FraisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FraisServiceImpl implements FraisService {

    private FraisRepository fraisRepository;

    private ModelMapper modelMapper;

    @Autowired
    public FraisServiceImpl(FraisRepository fraisRepository, ModelMapper modelMapper) {
        this.fraisRepository = fraisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FraisDto save(FraisDto fraisDto) {
        Frais frais = modelMapper.map(fraisDto,Frais.class);
        Frais saved = fraisRepository.save(frais);
        return modelMapper.map(saved,FraisDto.class);
    }

    @Override
    public FraisDto update(FraisDto fraisDto, int id) throws Exception {
        Optional<Frais> frais = fraisRepository.findById(id);
        if (frais.isPresent()){
            Frais frais1 = modelMapper.map(fraisDto,Frais.class);
            frais1.setId(id);
            Frais updated = fraisRepository.save(frais1);
            return modelMapper.map(updated,FraisDto.class);
        }else
            throw new Exception("faild to update Frais");
    }

    @Override
    public List<FraisDto> findAll() {
        return fraisRepository.findAll()
                .stream()
                .map(frais -> modelMapper.map(frais,FraisDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FraisDto findById(int id) throws Exception {
        Frais frais = fraisRepository.findById(id)
                .orElseThrow(() -> new Exception("Fail to get data for frais"));
        return modelMapper.map(frais,FraisDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Frais> frais = fraisRepository.findById(id);
        if (frais.isPresent()){
            fraisRepository.deleteById(id);
        }else
            throw new Exception("Fail to delete Frais");
    }
}
