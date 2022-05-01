package com.gestion.ecole.backend.service.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.Controle;
import com.gestion.ecole.backend.repository.ControleRepository;
import com.gestion.ecole.backend.service.ControleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ControleServiceImpl implements ControleService {

    private ControleRepository controleRepository;

    @Override
    public Controle save(Controle controle) {
        return controleRepository.save(controle);
    }

    @Override
    public Controle update(Controle controle, int id) throws Exception {
        Optional<Controle> controle1 = controleRepository.findById(id);
        if (controle1.isPresent()){
            controle.setId(id);
            return controleRepository.save(controle);
        }else
            throw new Exception("Controle not found");
    }

    @Override
    public List<Controle> findAll() {
        return controleRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Controle findById(int id) throws Exception {
        return controleRepository.findById(id).orElseThrow(() -> new Exception("Controle Not found"));
    }

    @Override
    public Controle findByLibelle(String libelle) {
        return controleRepository.findByLibelle(libelle);
    }
}
