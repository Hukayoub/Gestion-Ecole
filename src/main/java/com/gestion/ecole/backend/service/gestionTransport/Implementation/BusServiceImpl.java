package com.gestion.ecole.backend.service.gestionTransport.Implementation;

import com.gestion.ecole.backend.dto.BusDto;
import com.gestion.ecole.backend.models.gestionTransport.Bus;
import com.gestion.ecole.backend.repository.gestionTransport.BusRepository;
import com.gestion.ecole.backend.service.gestionTransport.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;

    private ModelMapper modelMapper;

    @Autowired
    public BusServiceImpl(BusRepository busRepository, ModelMapper modelMapper) {
        this.busRepository = busRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BusDto save(BusDto busDto) {
        Bus bus = modelMapper.map(busDto,Bus.class);
        Bus saved = busRepository.save(bus);
        return modelMapper.map(saved,BusDto.class);
    }

    @Override
    public BusDto update(BusDto busDto, int id) throws Exception {
        Optional<Bus> bus = busRepository.findById(id);
        if (bus.isPresent()){
            Bus bus1 = modelMapper.map(busDto,Bus.class);
            bus1.setId(id);
            Bus updated = busRepository.save(bus1);
            return modelMapper.map(updated,BusDto.class);
        }else
            throw new Exception("Fail to update bus");

    }

    @Override
    public List<BusDto> findAll() {
        return busRepository.findAll()
                .stream()
                .map(bus -> modelMapper.map(bus,BusDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BusDto findById(int id) throws Exception {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new Exception("fail to get bus data"));
        return modelMapper.map(bus,BusDto.class);
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Bus> bus = busRepository.findById(id);
        if (bus.isPresent()){
            busRepository.deleteById(id);
        }else
            throw new Exception("Fail to delete the bus");
    }
}
