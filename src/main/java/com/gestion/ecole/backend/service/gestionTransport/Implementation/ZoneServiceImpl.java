package com.gestion.ecole.backend.service.gestionTransport.Implementation;

import com.gestion.ecole.backend.dto.ZoneDto;
import com.gestion.ecole.backend.models.gestionTransport.Zone;
import com.gestion.ecole.backend.repository.gestionTransport.ZoneRepository;
import com.gestion.ecole.backend.service.gestionTransport.ZoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {

    private ZoneRepository zoneRepository;

    private ModelMapper modelMapper;

    @Autowired
    public ZoneServiceImpl(ZoneRepository zoneRepository, ModelMapper modelMapper) {
        this.zoneRepository = zoneRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ZoneDto save(ZoneDto zoneDto) {
        Zone zone = modelMapper.map(zoneDto,Zone.class);
        Zone saved = zoneRepository.save(zone);
        return modelMapper.map(saved,ZoneDto.class);
    }

    @Override
    public ZoneDto update(ZoneDto zoneDto, int id) throws Exception {
        Optional<Zone> zone = zoneRepository.findById(id);
        if (zone.isPresent()){
            Zone zone1 = modelMapper.map(zoneDto,Zone.class);
            zone1.setId(id);
            Zone updated = zoneRepository.save(zone1);
            return modelMapper.map(updated,ZoneDto.class);
        }else
            throw new Exception("fail to update current zone");
    }

    @Override
    public List<ZoneDto> findAll() {
        return zoneRepository.findAll()
                .stream()
                .map(zone -> modelMapper.map(zone,ZoneDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ZoneDto findById(int id) throws Exception {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new Exception("fail to get data for the current zone"));
        return null;
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Zone> zone = zoneRepository.findById(id);
        if (zone.isPresent()){
            zoneRepository.deleteById(id);
        }else
            throw new Exception("Zone not founded \n Fail to delete");
    }
}
