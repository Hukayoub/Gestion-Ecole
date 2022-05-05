package com.gestion.ecole.backend.service.gestionEleve.Implementation;

import com.gestion.ecole.backend.models.gestionTransport.GroupeTransport;
import com.gestion.ecole.backend.repository.gestionTransport.GroupeTransportRepository;
import com.gestion.ecole.backend.service.gestionEleve.GroupeTransportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupeTransportServiceImpl implements GroupeTransportService {

    private GroupeTransportRepository groupeTransportRepository;

    @Override
    public GroupeTransport save(GroupeTransport groupeTransport) {
        return groupeTransportRepository.save(groupeTransport);
    }

    @Override
    public GroupeTransport update(GroupeTransport groupeTransport, int id) throws Exception {
        Optional<GroupeTransport> groupeTransport1 = groupeTransportRepository.findById(id);
        if (groupeTransport1.isPresent()){
            groupeTransport.setId(id);
            return groupeTransportRepository.save(groupeTransport);
        }else
            throw new Exception("Groupe Transport not found");
    }

    @Override
    public List<GroupeTransport> findAll() {
        return groupeTransportRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public GroupeTransport findById(int id) throws Exception {
        return groupeTransportRepository.findById(id).orElseThrow(() -> new Exception("Groupe transport not found"));
    }

    @Override
    public GroupeTransport findBySurnom(String surnom) {
        return groupeTransportRepository.findBySurnom(surnom);
    }
}
