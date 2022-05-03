package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Discipline;
import com.gestion.ecole.backend.repository.DisciplineRepository;
import com.gestion.ecole.backend.service.gestionEleve.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public Discipline update(Discipline discipline, int id) throws Exception {
        Optional<Discipline> discipline1 = disciplineRepository.findById(id);
        if(discipline1.isPresent()){
            discipline.setId(id);
            return disciplineRepository.save(discipline);
        }else
            throw new Exception("Discipline not found");
    }

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Discipline findById(int id) throws Exception {
        return disciplineRepository.findById(id).orElseThrow(() -> new Exception("Discipline not found"));
    }

    @Override
    public Discipline findByNom(String nom) {
        return disciplineRepository.findByNom(nom);
    }
}
