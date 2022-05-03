package com.meli.jupiter.infrastructure.entry_points.api_rest.api;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.usecase.SatelliteUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {

    @Autowired
    private SatelliteUseCase satelliteUseCase;

    @GetMapping("/all")
    @ApiOperation("Get all Satellites")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Satellite>> getAll() {
        return new ResponseEntity<>(satelliteUseCase.getAllSatellites(), HttpStatus.OK);
    }
}
