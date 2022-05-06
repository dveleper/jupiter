package com.meli.jupiter.infrastructure.entry_points.api_rest.api;

import com.meli.jupiter.domain.model.Satellite;
import com.meli.jupiter.domain.usecase.SatelliteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Listar todos los satelites registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "lista de satelites",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "no se pueda determinar la posición o el mensaje",
                    content = @Content)})
    @GetMapping("/all")
    public ResponseEntity<List<Satellite>> getAll() {
        return new ResponseEntity<>(satelliteUseCase.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener datos de satelite por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "satelite encontrado exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)) }),
            @ApiResponse(responseCode = "404", description = "no se encontraron datos del satelite",
                    content = @Content)})
    @GetMapping("/get/{nameSatellite}")
    public ResponseEntity<Satellite> getByName(@PathVariable("nameSatellite") String name) {
        return satelliteUseCase.getSatellite(name).map(
                satellite -> new ResponseEntity<>(satellite, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Agregar nuevo satelite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "satelite guardado exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)) })})
    @PostMapping("/save")
    public ResponseEntity<Satellite> save(@RequestBody Satellite satellite) {
        return new ResponseEntity<>(satelliteUseCase.save(satellite), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar satelite por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "satelite eliminado exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)) })})
    @DeleteMapping("/delete/{name}")
    public ResponseEntity delete(@PathVariable("name") String name) {
        if (satelliteUseCase.delete(name)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Actualizar satelite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "satelite actualizado exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)) })})
    @PutMapping("/update")
    public ResponseEntity<Satellite> update(@RequestBody Satellite satellite) {
        return new ResponseEntity<>(satelliteUseCase.save(satellite), HttpStatus.OK);
    }
}
