package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    public List<Airport> listAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> findAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public List<Airport> findAirportsByCity(String city) {
        return airportRepository.findByCity(city);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id,Airport airport) {
        if (airportRepository.existsById(id)) {
            airport.setId(id);
            return airportRepository.save(airport);
        }
        return null;
    }

    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }

}
