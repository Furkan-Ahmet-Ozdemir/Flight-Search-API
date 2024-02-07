package com.example.flightsearchapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

//    @Column(nullable = false)
//    private String departureAirport;
//
//    @Column(nullable = false)
//    private String arrivalAirport;

    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "Departure-Airport")
    private Airport departureAirport;

    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "Arrival-Airport")
    private Airport arrivalAirport;



    @Column(nullable = false)
    private LocalDateTime departureTime;

    private LocalDateTime returnTime;

    private double price;

}
