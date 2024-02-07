package com.example.flightsearchapi.service;


import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.model.Flight;
import com.example.flightsearchapi.repository.AirportRepository;
import com.example.flightsearchapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    private AirportService airportService;
    private final AirportRepository airportRepository;

    public FlightService(FlightRepository flightRepository, AirportService airportService,
                         AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
        this.airportRepository = airportRepository;
    }




    public List<Flight> listAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlightById(Long id) {
        return flightRepository.findById(id);
    }


    public List<Flight> searchFlights(String dep, String arr, LocalDateTime departureTime, LocalDateTime returnTime) {

        Long departureAirportId = airportRepository.getAirportByCity(dep).getId();
        Long arrivalAirportId = airportRepository.getAirportByCity(arr).getId();

        if (returnTime == null){
            // Search for one-way flights

            return flightRepository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureTimeGreaterThanEqual(departureAirportId, arrivalAirportId, departureTime);
        } else {
            // Search for round-trip flights

            List<Flight> departureFlights = flightRepository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureTimeGreaterThanEqual(departureAirportId, arrivalAirportId, departureTime);
            List<Flight> returnFlights = flightRepository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureTimeGreaterThanEqual(arrivalAirportId, departureAirportId, returnTime);

            List<Flight> totalFlights = new ArrayList<>();

            totalFlights.addAll(departureFlights);
            totalFlights.addAll(returnFlights);

            return totalFlights;
        }
    }


    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setId(id);
            return flightRepository.save(flight);
        }
        return null;
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

}
