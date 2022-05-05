package com.gestion.ecole.backend.service.gestionTransport.Implementation;

import com.gestion.ecole.backend.dto.PersonnelDto;
import com.gestion.ecole.backend.models.gestionTransport.Personnel;
import com.gestion.ecole.backend.repository.gestionTransport.PersonnelRepository;
import com.gestion.ecole.backend.service.gestionTransport.PersonnelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    private PersonnelRepository personnelRepository;

    private ModelMapper modelMapper;

    @Autowired
    public PersonnelServiceImpl(PersonnelRepository personnelRepository, ModelMapper modelMapper) {
        this.personnelRepository = personnelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonnelDto save(PersonnelDto personnelDto) {
        Personnel personnel = modelMapper.map(personnelDto,Personnel.class);
        Personnel saved = personnelRepository.save(personnel);
        return modelMapper.map(saved,PersonnelDto.class);
    }

    @Override
    public PersonnelDto update(PersonnelDto personnelDto, int id) throws Exception {
        Optional<Personnel> personnel = personnelRepository.findById(id);
        if (personnel.isPresent()){
            Personnel personnel1 = modelMapper.map(personnelDto,Personnel.class);
            personnel1.setId(id);
            Personnel updated = personnelRepository.save(personnel1);
            return modelMapper.map(updated,PersonnelDto.class);
        }else
            throw new Exception("fail to update personnel");
    }

    @Override
    public List<PersonnelDto> findAll() {
        return personnelRepository.findAll()
                .stream()
                .map(personnel -> modelMapper.map(personnel,PersonnelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonnelDto findById(int id) throws Exception {
        Personnel personnel = personnelRepository.findById(id).orElseThrow(() -> new Exception("fail to get personnel date"));
        return modelMapper.map(personnel,PersonnelDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Personnel> personnel = personnelRepository.findById(id);
        if (personnel.isPresent()){
            personnelRepository.deleteById(id);
        }else
            throw new Exception("Fail to delete current personnel");
    }
}
