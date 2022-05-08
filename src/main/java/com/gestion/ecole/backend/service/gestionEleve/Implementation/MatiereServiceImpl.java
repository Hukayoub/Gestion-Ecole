package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Matiere;
import com.gestion.ecole.backend.repository.gestionEleve.MatiereRepository;
import com.gestion.ecole.backend.service.gestionEleve.MatiereService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatiereServiceImpl implements MatiereService {

    private MatiereRepository matiereRepository;

    @Override
    public Matiere save(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere update(Matiere matiere, int id) throws Exception {
        Optional<Matiere> matiere1 = matiereRepository.findById(id);
        if (matiere1.isPresent()){
            matiere.setId(id);
            return matiereRepository.save(matiere);
        }else
            throw new Exception("Matiere not found");
    }

    @Override
    public List<Matiere> findAll() {
        return matiereRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Matiere findById(int id) throws Exception {
        return matiereRepository.findById(id)
                .orElseThrow(() -> new Exception("Matiere not found"));
    }

    @Override
    public Matiere findByNom(String nom) {
        return matiereRepository.findByNom(nom);
    }
}
