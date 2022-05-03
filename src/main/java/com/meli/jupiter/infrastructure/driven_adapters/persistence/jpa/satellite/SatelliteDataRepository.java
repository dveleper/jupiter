package com.meli.jupiter.infrastructure.driven_adapters.persistence.jpa.satellite;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SatelliteDataRepository extends CrudRepository<SatelliteData, Integer> {

    Optional<SatelliteData> findByName(String name);
}
