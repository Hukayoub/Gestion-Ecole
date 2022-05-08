package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Niveau;
import com.gestion.ecole.backend.repository.gestionEleve.NiveauRepository;
import com.gestion.ecole.backend.service.gestionEleve.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NiveauServiceImpl implements NiveauService {

    @Autowired
    private NiveauRepository niveauRepository;

    @Override
    public Niveau save(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau update(Niveau niveau, int id) throws Exception {
        Optional<Niveau> niveau1 = niveauRepository.findById(id);
        if (niveau1.isPresent()){
            niveau.setId(id);
            return niveauRepository.save(niveau);
        }else
            throw new Exception("Niveau not found");
    }

    @Override
    public List<Niveau> findAll() {
        return niveauRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Niveau findById(int id) throws Exception {
        return niveauRepository.findById(id)
                .orElseThrow(() -> new Exception("Niveau not found"));
    }
}
