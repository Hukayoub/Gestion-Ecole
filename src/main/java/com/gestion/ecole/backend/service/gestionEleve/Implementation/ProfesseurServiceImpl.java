package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Professeur;
import com.gestion.ecole.backend.repository.ProfesseurRepository;
import com.gestion.ecole.backend.service.gestionEleve.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Override
    public Professeur save(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @Override
    public Professeur update(Professeur professeur, int id) throws Exception {
        Optional<Professeur> professeur1 = professeurRepository.findById(id);
        if (professeur1.isPresent()){
            professeur.setId(id);
            return professeurRepository.save(professeur);
        }else
            throw new Exception("Professeur not found");
    }

    @Override
    public List<Professeur> findAll() {
        return professeurRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Professeur findById(int id) throws Exception {
        return professeurRepository.findById(id)
                .orElseThrow(() -> new Exception("Professeur not found"));
    }

    @Override
    public Professeur findByNomAndPrenom(String nom, String prenom) {
        return professeurRepository.findByNomAndPrenom(nom, prenom);
    }
}
