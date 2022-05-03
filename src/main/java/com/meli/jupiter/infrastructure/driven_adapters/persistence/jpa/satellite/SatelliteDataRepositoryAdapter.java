package com.meli.jupiter.infrastructure.driven_adapters.persistence.jpa.satellite;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.model.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SatelliteDataRepositoryAdapter implements SatelliteRepository {

    @Autowired
    private SatelliteDataRepository satelliteDataRepository;

    @Autowired
    private SatelliteMapper mapper;

    @Override
    public List<Satellite> getAll() {
        List<SatelliteData> satelliteAll = (List<SatelliteData>) satelliteDataRepository.findAll();
        return mapper.toSatellites(satelliteAll);
    }

    @Override
    public Satellite save(Satellite satellite) {
        SatelliteData satelliteData = mapper.toSatelliteData(satellite);
        return mapper.toSatellite(satelliteDataRepository.save(satelliteData));
    }

    @Override
    public Optional<Satellite> getSatellite(String nombre) {
        return satelliteDataRepository.findByName(nombre).map(satelliteData -> mapper.toSatellite(satelliteData));
    }

    @Override
    public boolean delete(String nombre) {
        return satelliteDataRepository.findByName(nombre).map(satelliteData -> {
            satelliteDataRepository.delete(satelliteData);
            return true;
        }).orElse(false);
    }
}
