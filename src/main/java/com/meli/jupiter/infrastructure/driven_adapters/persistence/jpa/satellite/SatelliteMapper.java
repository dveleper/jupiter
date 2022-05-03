package com.meli.jupiter.infrastructure.driven_adapters.persistence.jpa.satellite;

import com.meli.jupiter.domain.model.Satellite;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatelliteMapper {
    @Mappings({
            @Mapping(source = "name", target = "nombre"),
            @Mapping(source = "distance", target = "distancia"),
            @Mapping(source = "message", target = "mensaje")
    })
    Satellite toSatellite(SatelliteData satelliteData);

    List<Satellite> toSatellites(List<SatelliteData> satellites);

    @InheritInverseConfiguration
    SatelliteData toSatelliteData(Satellite satellite);
}
