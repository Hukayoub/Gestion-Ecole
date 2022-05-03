package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Eleve;
import com.gestion.ecole.backend.repository.EleveRepository;
import com.gestion.ecole.backend.service.gestionEleve.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    @Override
    public Eleve save(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve update(Eleve eleve, int id) throws Exception {
        Optional<Eleve> eleve1 = eleveRepository.findById(id);
        if (eleve1.isPresent()){
            eleve.setId(id);
            return eleveRepository.save(eleve);
        }else
            throw new Exception("Eleve not found");
    }

    @Override
    public List<Eleve> findAll() {
        return eleveRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Eleve findById(int id) throws Exception {
        return eleveRepository.findById(id).orElseThrow(() -> new Exception("Eleve not found"));
    }

    @Override
    public Eleve findByCin(String cin) {
        return eleveRepository.findByCin(cin);
    }

    @Override
    public Eleve findByCne(String cne) {
        return eleveRepository.findByCne(cne);
    }

    @Override
    public Eleve findByNomAndPrenom(String nom, String prenom) {
        return eleveRepository.findByNomAndPrenom(nom,prenom);
    }
}
