package com.gestion.ecole.backend.service.gestionProfesseur.Implementation;

import com.gestion.ecole.backend.dto.RetardProfesseurDto;
import com.gestion.ecole.backend.models.gestionProfesseur.RetardProfesseur;
import com.gestion.ecole.backend.repository.gestionProfesseur.RetardProfesseurRepository;
import com.gestion.ecole.backend.service.gestionProfesseur.RetardProfesseurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RetardProfesseurServiceImpl implements RetardProfesseurService {

    private RetardProfesseurRepository retardProfesseurRepository;

    private ModelMapper modelMapper;

    @Autowired
    public RetardProfesseurServiceImpl(RetardProfesseurRepository retardProfesseurRepository, ModelMapper modelMapper) {
        this.retardProfesseurRepository = retardProfesseurRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public RetardProfesseurDto save(RetardProfesseurDto retardProfesseurDto) {
        RetardProfesseur professeur = modelMapper.map(retardProfesseurDto,RetardProfesseur.class);
        RetardProfesseur saved = retardProfesseurRepository.save(professeur);
        return modelMapper.map(saved,RetardProfesseurDto.class);
    }

    @Override
    public RetardProfesseurDto update(RetardProfesseurDto retardProfesseurDto, int id) throws Exception {
        Optional<RetardProfesseur> professeur = retardProfesseurRepository.findById(id);
        if(professeur.isPresent()){
            RetardProfesseur professeur1 = modelMapper.map(retardProfesseurDto,RetardProfesseur.class);
            professeur1.setId(id);
            RetardProfesseur updated = retardProfesseurRepository.save(professeur1);
            return modelMapper.map(updated,RetardProfesseurDto.class);
        }else
            throw new Exception("Fail to update retard professeur");
    }

    @Override
    public List<RetardProfesseurDto> findAll() {
        return retardProfesseurRepository.findAll()
                .stream()
                .map(retardProfesseur -> modelMapper.map(retardProfesseur,RetardProfesseurDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RetardProfesseurDto findById(int id) throws Exception {
        RetardProfesseur professeur = retardProfesseurRepository.findById(id)
                .orElseThrow(() -> new Exception("fail to get retard professeur"));
        return modelMapper.map(professeur,RetardProfesseurDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<RetardProfesseur> professeur = retardProfesseurRepository.findById(id);
        if (professeur.isPresent()){
            retardProfesseurRepository.deleteById(id);
        }else
            throw new Exception("fail to delete retard professeur");
    }
}
