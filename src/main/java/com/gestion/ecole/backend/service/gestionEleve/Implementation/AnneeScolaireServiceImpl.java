package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaire;
import com.gestion.ecole.backend.models.gestionEleve.AnneeScolaireKey;
import com.gestion.ecole.backend.repository.AnneeScolaireRepository;
import com.gestion.ecole.backend.service.gestionEleve.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnneeScolaireServiceImpl implements AnneeScolaireService {

    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public AnneeScolaire save(AnneeScolaire anneeScolaire) {

        return anneeScolaireRepository.save(anneeScolaire);
    }

    @Override
    public AnneeScolaire update(AnneeScolaire anneeScolaire, AnneeScolaireKey key) throws Exception {
        Optional<AnneeScolaire> scolaire = anneeScolaireRepository.findById(key);
        if (scolaire.isPresent()){
            anneeScolaire.setId(key);
            return anneeScolaireRepository.save(anneeScolaire);

        }else
            throw new Exception("Annee scolaire not found");
    }

    @Override
    public List<AnneeScolaire> findAll() {

        return anneeScolaireRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public AnneeScolaire findById(AnneeScolaireKey key) throws Exception {
        return anneeScolaireRepository.findById(key).orElseThrow(() -> new Exception("Annee scolaire not found"));
    }

}
