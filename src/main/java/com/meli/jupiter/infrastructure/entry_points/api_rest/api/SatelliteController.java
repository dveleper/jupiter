package com.meli.jupiter.infrastructure.entry_points.api_rest.api;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.usecase.SatelliteUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return new ResponseEntity<>(satelliteUseCase.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{nameSatellite}")
    public ResponseEntity<Satellite> getByName(@PathVariable("nameSatellite") String name) {
        return satelliteUseCase.getSatellite(name).map(
                satellite -> new ResponseEntity<>(satellite, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Satellite> save(@RequestBody Satellite satellite) {
        return new ResponseEntity<>(satelliteUseCase.save(satellite), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity delete(@PathVariable("name") String name) {
        if (satelliteUseCase.delete(name)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Satellite> update(@RequestBody Satellite satellite) {
        return new ResponseEntity<>(satelliteUseCase.save(satellite), HttpStatus.OK);
    }
}
