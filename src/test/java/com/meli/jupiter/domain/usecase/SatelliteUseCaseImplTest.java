package com.meli.jupiter.domain.usecase;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.model.repository.SatelliteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SatelliteUseCaseImplTest {

    @InjectMocks
    @Spy
    SatelliteUseCaseImpl satelliteUseCase;

    @Mock
    SatelliteRepository satelliteRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTest() {
        List<Satellite> satellites = new ArrayList<>();
        satellites.add(Satellite.builder().nombre("testSatellite").build());
        when(satelliteRepository.getAll()).thenReturn(satellites);
        List<Satellite> all = satelliteUseCase.getAll();
        assertNotNull(all.size());
    }

    @Test
    public void saveTest() {
        when(satelliteRepository.save(Mockito.any(Satellite.class)))
                .thenReturn(Satellite.builder().nombre("testSatellite").build());
        Satellite satellite = satelliteUseCase.save(Satellite.builder().build());
        assertNotNull(satellite);
    }

    @Test
    public void getSatellite() {
        when(satelliteRepository.getSatellite(Mockito.anyString()))
                .thenReturn(Optional.of(Satellite.builder().nombre("testSatellite").build()));
        Optional<Satellite> satellite = satelliteUseCase.getSatellite("test");
        assertNotNull(satellite.get());
    }

    @Test
    public void delete() {
        when(satelliteRepository.delete(Mockito.anyString()))
                .thenReturn(true);
        assertTrue(satelliteUseCase.delete("test"));
    }
}