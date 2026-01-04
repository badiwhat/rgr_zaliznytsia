package com.example.services;

import com.example.models.*;
import com.example.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor // Lombok сам підключить репозиторії
public class ZaliznytsiaService {

    private final CityRepository cityRepository;
    private final StationRepository stationRepository;
    private final TripRepository tripRepository;

    // Отримати всі міста
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Отримати вокзали конкретного міста
    public List<Station> getStationsByCity(Long cityId) {
        return stationRepository.findAll().stream()
                .filter(s -> s.getCity().getId().equals(cityId))
                .toList();
    }

    // Отримати всі рейси
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Видалити рейс (тільки для ADMIN)
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
}