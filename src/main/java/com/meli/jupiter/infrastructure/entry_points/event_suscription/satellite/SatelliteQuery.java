package com.meli.jupiter.infrastructure.entry_points.event_suscription.satellite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SatelliteQuery {
    private String name;
}
