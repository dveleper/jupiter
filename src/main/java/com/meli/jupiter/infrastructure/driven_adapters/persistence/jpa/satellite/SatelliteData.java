package com.meli.jupiter.infrastructure.driven_adapters.persistence.jpa.satellite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="satellite")
@AllArgsConstructor
@NoArgsConstructor
public class SatelliteData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_satelite")
    private Integer idSatellite;
    private String name;
    private Double distance;
    private String message;

    public Integer getIdSatellite() {
        return idSatellite;
    }

    public void setIdSatellite(Integer idSatellite) {
        this.idSatellite = idSatellite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
