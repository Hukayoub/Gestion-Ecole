package com.gestion.ecole.backend.service.gestionTransport.Implementation;

import com.gestion.ecole.backend.dto.ProgrammeTransportDto;
import com.gestion.ecole.backend.models.gestionTransport.ProgrammeTransport;
import com.gestion.ecole.backend.repository.gestionTransport.ProgrammeTransportRepository;
import com.gestion.ecole.backend.service.gestionTransport.ProgrammeTransportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgrammeTransportServiceImpl implements ProgrammeTransportService {

    private ProgrammeTransportRepository transportRepository;

    private ModelMapper modelMapper;

    @Autowired
    public ProgrammeTransportServiceImpl(ProgrammeTransportRepository transportRepository, ModelMapper modelMapper) {
        this.transportRepository = transportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProgrammeTransportDto save(ProgrammeTransportDto transportDto) {
        ProgrammeTransport programmeTransport = modelMapper.map(transportDto,ProgrammeTransport.class);
        ProgrammeTransport saved = transportRepository.save(programmeTransport);
        return modelMapper.map(saved,ProgrammeTransportDto.class);
    }

    @Override
    public ProgrammeTransportDto update(ProgrammeTransportDto transportDto, int id) throws Exception {
        Optional<ProgrammeTransport> programmeTransport = transportRepository.findById(id);
        if (programmeTransport.isPresent()){
            ProgrammeTransport programmeTransport1 = modelMapper.map(transportDto,ProgrammeTransport.class);
            programmeTransport1.setId(id);
            ProgrammeTransport updated = transportRepository.save(programmeTransport1);
            return modelMapper.map(updated,ProgrammeTransportDto.class);
        }else
            throw new Exception("fail to update programme transport");

    }

    @Override
    public List<ProgrammeTransportDto> findAll() {
        return transportRepository.findAll()
                .stream()
                .map(programmeTransport -> modelMapper.map(programmeTransport,ProgrammeTransportDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProgrammeTransportDto findById(int id) throws Exception {
        ProgrammeTransport programmeTransport = transportRepository.findById(id)
                .orElseThrow(() -> new Exception("fail to get data for current programme transport"));
        return modelMapper.map(programmeTransport,ProgrammeTransportDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<ProgrammeTransport> programmeTransport = transportRepository.findById(id);
        if (programmeTransport.isPresent()){
            transportRepository.deleteById(id);
        }else
            throw new Exception("fail to delete the current Programme transport");
    }
}
