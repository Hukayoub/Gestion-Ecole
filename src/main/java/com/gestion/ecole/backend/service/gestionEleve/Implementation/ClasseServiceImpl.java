package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Classe;
import com.gestion.ecole.backend.repository.gestionEleve.ClasseRepository;
import com.gestion.ecole.backend.service.gestionEleve.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public Classe save(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public Classe update(Classe classe, int id) throws Exception {
        Optional<Classe> classe1 = classeRepository.findById(id);
        if (classe1.isPresent()){
            classe.setId(id);
            return classeRepository.save(classe);
        }else
            throw new Exception("Classe not found");
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Classe findById(int id) throws Exception {
        return classeRepository.findById(id)
                .orElseThrow(() -> new Exception("Classe not found"));
    }

    @Override
    public Classe findBySurnom(String surnom) {
        return classeRepository.findBySurnom(surnom);
    }
}
