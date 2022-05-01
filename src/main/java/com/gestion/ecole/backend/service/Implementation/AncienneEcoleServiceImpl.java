package com.gestion.ecole.backend.service.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.AncienneEcole;
import com.gestion.ecole.backend.repository.AncienneEcoleRepository;
import com.gestion.ecole.backend.service.AncienneEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AncienneEcoleServiceImpl implements AncienneEcoleService {

    @Autowired
    private AncienneEcoleRepository ancienneEcoleRepository;

    @Override
    public AncienneEcole save(AncienneEcole ancienneEcole) {
        return ancienneEcoleRepository.save(ancienneEcole);
    }

    @Override
    public AncienneEcole update(AncienneEcole ancienneEcole, int id) throws Exception {
        Optional<AncienneEcole> ecole = ancienneEcoleRepository.findById(id);
        if(ecole.isPresent()){
            ancienneEcole.setId(id);
            return ancienneEcoleRepository.save(ancienneEcole);
        }else
            throw new Exception("Ancienne ecole not found");
    }

    @Override
    public List<AncienneEcole> findAll() {
        return ancienneEcoleRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public AncienneEcole findById(int id) throws Exception {
        return ancienneEcoleRepository.findById(id).orElseThrow(() -> new Exception("Ecole not found"));
    }

}
