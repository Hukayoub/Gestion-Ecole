package com.gestion.ecole.backend.service.gestionProfesseur.Implementation;

import com.gestion.ecole.backend.dto.AbsenceProfesseurDto;
import com.gestion.ecole.backend.models.gestionProfesseur.AbsenceProfesseur;
import com.gestion.ecole.backend.repository.gestionProfesseur.AbsenceProfesseurRepository;
import com.gestion.ecole.backend.service.gestionProfesseur.AbsenceProfesseurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbsenceProfesseurServiceImpl implements AbsenceProfesseurService {

    private AbsenceProfesseurRepository absenceProfesseurRepository;

    private ModelMapper modelMapper;

    @Autowired
    public AbsenceProfesseurServiceImpl(AbsenceProfesseurRepository absenceProfesseurRepository, ModelMapper modelMapper) {
        this.absenceProfesseurRepository = absenceProfesseurRepository;
        this.modelMapper = modelMapper;
    }

    public AbsenceProfesseurDto save(AbsenceProfesseurDto absenceProfesseurDto){
        AbsenceProfesseur professeur = modelMapper.map(absenceProfesseurDto,AbsenceProfesseur.class);
        AbsenceProfesseur saved = absenceProfesseurRepository.save(professeur);
        return modelMapper.map(saved,AbsenceProfesseurDto.class);
    }
    public AbsenceProfesseurDto update(AbsenceProfesseurDto absenceProfesseurDto,int id) throws Exception {
        Optional<AbsenceProfesseur> professeur = absenceProfesseurRepository.findById(id);
        if (professeur.isPresent()){
            AbsenceProfesseur professeur1 = modelMapper.map(absenceProfesseurDto,AbsenceProfesseur.class);
            professeur1.setId(id);
            AbsenceProfesseur updated = absenceProfesseurRepository.save(professeur1);
            return modelMapper.map(updated,AbsenceProfesseurDto.class);
        }else
            throw new Exception(" faild to delete Absence professeur");
    }
    public List<AbsenceProfesseurDto> findAll(){
        return absenceProfesseurRepository.findAll()
                .stream()
                .map(absenceProfesseur -> modelMapper.map(absenceProfesseur,AbsenceProfesseurDto.class))
                .collect(Collectors.toList());
    }
    public AbsenceProfesseurDto findById(int id) throws Exception {
         AbsenceProfesseur prof= absenceProfesseurRepository.findById(id)
                .orElseThrow(() -> new Exception("fail to get Absence professeur"));
        return modelMapper.map(prof,AbsenceProfesseurDto.class);
    }
    public void delete(int id) throws Exception {
        Optional<AbsenceProfesseur> professeur = absenceProfesseurRepository.findById(id);
        if (professeur.isPresent()){
            absenceProfesseurRepository.deleteById(id);
        }else
            throw new Exception("faild to delete Absence professeur");

    }
}
