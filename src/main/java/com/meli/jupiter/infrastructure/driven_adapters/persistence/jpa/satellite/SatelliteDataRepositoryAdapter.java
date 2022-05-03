package com.meli.jupiter.infrastructure.driven_adapters.persistence.jpa.satellite;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.model.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SatelliteDataRepositoryAdapter implements SatelliteRepository {

    @Autowired
    private SatelliteDataRepository satelliteDataRepository;

    @Autowired
    private SatelliteMapper satelliteMapper;

    @Override
    public List<Satellite> getAll() {
        List<SatelliteData> satellites = (List<SatelliteData>) satelliteDataRepository.findAll();
        return satelliteMapper.toSatellites(satellites);
    }
}
