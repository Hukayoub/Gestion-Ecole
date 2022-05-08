package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.AbsenceEleve;
import com.gestion.ecole.backend.repository.gestionEleve.AbsenceEleveRepository;
import com.gestion.ecole.backend.service.gestionEleve.AbsenceEleveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AbsenceEleveServiceImpl implements AbsenceEleveService {

    @Autowired
    private AbsenceEleveRepository absenceEleveRepository;

    @Override
    public AbsenceEleve save(AbsenceEleve absenceEleve) {
        return absenceEleveRepository.save(absenceEleve);
    }

    @Override
    public AbsenceEleve update(AbsenceEleve absenceEleve, int id) throws Exception {
       Optional<AbsenceEleve> eleve = absenceEleveRepository.findById(id);
       if (eleve.isPresent()){
           absenceEleve.setId(id);
           return absenceEleveRepository.save(absenceEleve);
       }else
           throw new Exception("Absence eleve not found");

    }

    @Override
    public List<AbsenceEleve> findAll() {
        return absenceEleveRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public AbsenceEleve findById(int id) throws Exception {
        AbsenceEleve eleve = absenceEleveRepository.findById(id).orElseThrow(() -> new Exception("Absence Eleve not found"));
        return eleve;
    }

}
