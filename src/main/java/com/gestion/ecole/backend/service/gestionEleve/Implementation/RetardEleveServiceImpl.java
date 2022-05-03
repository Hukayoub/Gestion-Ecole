package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.RetardEleve;
import com.gestion.ecole.backend.repository.RetardEleveRepository;
import com.gestion.ecole.backend.service.gestionEleve.RetardEleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RetardEleveServiceImpl implements RetardEleveService {

    @Autowired
    private RetardEleveRepository retardEleveRepository;

    @Override
    public RetardEleve save(RetardEleve retardEleve) {
        return retardEleveRepository.save(retardEleve);
    }

    @Override
    public RetardEleve update(RetardEleve retardEleve, int id) throws Exception {
        Optional<RetardEleve> retardEleve1 = retardEleveRepository.findById(id);
        if (retardEleve1.isPresent()){
            retardEleve.setId(id);
            return retardEleveRepository.save(retardEleve);
        }else
            throw new Exception("Retard eleve not found");
    }

    @Override
    public List<RetardEleve> findAll() {
        return retardEleveRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public RetardEleve findById(int id) throws Exception {
        return retardEleveRepository.findById(id)
                .orElseThrow(() -> new Exception("Retard eleve not found"));
    }
}
