package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Parent;
import com.gestion.ecole.backend.repository.ParentRepository;
import com.gestion.ecole.backend.service.gestionEleve.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ParentServiceImpl implements ParentService {

    private ParentRepository parentRepository;

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent update(Parent parent, int id) throws Exception {
        Optional<Parent> parent1 = parentRepository.findById(id);
        if (parent1.isPresent()){
            parent.setId(id);
            return parentRepository.save(parent);
        }else
            throw new Exception("Parent not found");
    }

    @Override
    public List<Parent> findAll() {
        return parentRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Parent findById(int id) throws Exception {
        return parentRepository.findById(id).orElseThrow(() -> new Exception("Parent not found"));
    }

    @Override
    public Parent findByNomAndPrenom(String nom, String prenom) {
        return parentRepository.findByNomAndPrenom(nom,prenom);
    }

    @Override
    public Parent findByCin(String cin) {
        return parentRepository.findByCin(cin);
    }
}
