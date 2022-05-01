package com.gestion.ecole.backend.service.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.EmploiTemps;
import com.gestion.ecole.backend.repository.EmploiTempsRepository;
import com.gestion.ecole.backend.service.EmploiTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmploiTempsServiceImpl implements EmploiTempsService {

    @Autowired
    private EmploiTempsRepository emploiTempsRepository;

    @Override
    public EmploiTemps save(EmploiTemps emploiTemps) {
        return emploiTempsRepository.save(emploiTemps);
    }

    @Override
    public EmploiTemps update(EmploiTemps emploiTemps, int id) throws Exception {
        Optional<EmploiTemps> emploiTemps1 = emploiTempsRepository.findById(id);
        if (emploiTemps1.isPresent()){
            emploiTemps.setId(id);
            return emploiTempsRepository.save(emploiTemps);
        }else
            throw new Exception("Emploi temps not found");
    }

    @Override
    public List<EmploiTemps> findAll() {
        return emploiTempsRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public EmploiTemps findById(int id) throws Exception {
        return emploiTempsRepository.findById(id).orElseThrow(() -> new Exception("Emploi temps not found"));
    }
}
