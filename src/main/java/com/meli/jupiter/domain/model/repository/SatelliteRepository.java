package com.meli.jupiter.domain.model.repository;

import com.meli.jupiter.domain.model.Satellite;

import java.util.List;

public interface SatelliteRepository {
    List<Satellite> getAll();

    Satellite save(Satellite satellite);
}
