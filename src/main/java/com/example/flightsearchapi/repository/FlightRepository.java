package com.example.flightsearchapi.repository;


import com.example.flightsearchapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportIdAndArrivalAirportIdAndDepartureTimeGreaterThanEqual(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureDateTime);

}
