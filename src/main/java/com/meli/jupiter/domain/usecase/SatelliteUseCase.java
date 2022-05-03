package com.meli.jupiter.domain.usecase;

import com.meli.jupiter.domain.model.Satellite;

import java.util.List;
import java.util.Optional;

public interface SatelliteUseCase {
    List<Satellite> getAll();
    Satellite save(Satellite satellite);
    Optional<Satellite> getSatellite(String nombre);
    boolean delete(String nombre);
}
