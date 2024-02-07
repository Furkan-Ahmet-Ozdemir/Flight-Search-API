package com.example.flightsearchapi.repository;


import com.example.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCity(String city);

    Airport getAirportByCity(String City);
}
