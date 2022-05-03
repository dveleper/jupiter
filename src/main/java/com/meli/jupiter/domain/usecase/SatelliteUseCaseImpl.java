package com.meli.jupiter.domain.usecase;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.model.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SatelliteUseCaseImpl implements SatelliteUseCase {

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Override
    public List<Satellite> getAll() {
        return satelliteRepository.getAll();
    }

    @Override
    public Satellite save(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    @Override
    public Optional<Satellite> getSatellite(String nombre) {
        return satelliteRepository.getSatellite(nombre);
    }

    @Override
    public boolean delete(String nombre) {
        return satelliteRepository.delete(nombre);
    }
}
