package com.example.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripNumber;
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station; // Зв'язок з вокзалом
}