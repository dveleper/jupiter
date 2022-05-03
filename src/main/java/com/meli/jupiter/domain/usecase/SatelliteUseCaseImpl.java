package com.meli.jupiter.domain.usecase;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.model.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SatelliteUseCaseImpl implements SatelliteUseCase {

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Override
    public List<Satellite> getAllSatellites() {
        return satelliteRepository.getAll();
    }
}
