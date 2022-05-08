package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionEleve.GroupeCantine;
import com.gestion.ecole.backend.repository.gestionEleve.GroupeCantineRepository;
import com.gestion.ecole.backend.service.gestionEleve.GroupeCantineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupeCantineServiceImpl implements GroupeCantineService {

    @Autowired
    private GroupeCantineRepository groupeCantineRepository;

    @Override
    public GroupeCantine save(GroupeCantine groupeCantine) {
        return groupeCantineRepository.save(groupeCantine);
    }

    @Override
    public GroupeCantine update(GroupeCantine groupeCantine, int id) throws Exception {
        Optional<GroupeCantine> groupeCantine1 = groupeCantineRepository.findById(id);
        if (groupeCantine1.isPresent()){
            groupeCantine.setId(id);
            return groupeCantineRepository.save(groupeCantine);
        }else
            throw new Exception("Groupe cantine not found");
    }

    @Override
    public List<GroupeCantine> findAll() {
        return groupeCantineRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public GroupeCantine findById(int id) throws Exception {
        return groupeCantineRepository.findById(id).orElseThrow(() -> new Exception("Groupe cantine not found"));
    }

    @Override
    public GroupeCantine findBySurnom(String surnom) {
        return groupeCantineRepository.findBySurnom(surnom);
    }
}
