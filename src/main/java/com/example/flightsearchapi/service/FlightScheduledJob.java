package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduledJob {

    @Autowired
    private FlightService flightService;

    @Scheduled(cron = "0 0 1-2 * * *") // Scheduled to work for every day at 01:00 AM and 02:00 AM
    public void addFlights() {
        int price = 1000;
        for(int i=0; i<24; i++){
            flightService.saveFlight(new Flight("2023-08-19T"+ i +":30:00", "2023-08-19T"+ (i+2) +":30:00", 1L, 2L, price));



        }
        price += 1;
    }


}
