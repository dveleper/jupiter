package com.meli.jupiter.infrastructure.entry_points.event_suscription.listener;

import com.meli.jupiter.domain.usecase.SatelliteUseCase;
import com.meli.jupiter.infrastructure.entry_points.event_suscription.satellite.SatelliteQuery;
import com.meli.jupiter.infrastructure.entry_points.event_suscription.satellite.SatelliteReply;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import static com.meli.jupiter.utils.Constants.EVENT_SATELLITE;
import static org.reactivecommons.async.api.HandlerRegistry.register;

@EnableMessageListeners
@Configuration
@RequiredArgsConstructor
public class JupiterListener {

    @Autowired
    private SatelliteUseCase satelliteUseCase;

    @Bean
    public HandlerRegistry handleEventSubscriptions() {
        return register()
                .serveQuery(EVENT_SATELLITE, this::getSatelliteResult, SatelliteQuery.class);
    }

    private Mono<SatelliteReply> getSatelliteResult(SatelliteQuery satelliteQuery) {
        return satelliteUseCase.getSatellite(satelliteQuery.getName())
                .map(satellite -> {
                    return Mono.just(SatelliteReply
                            .builder()
                            .distance(String.valueOf(satellite.getDistancia())).message(satellite.getMensaje())
                            .build());
                }).orElse(Mono.just(SatelliteReply.builder().build()));
    }
}
