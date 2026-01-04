package com.example.controllers;

import com.example.services.ZaliznytsiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.models.Trip;

@Controller
@RequiredArgsConstructor
public class ZaliznytsiaController {

    private final ZaliznytsiaService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("trips", service.getAllTrips());
        return "index";
    }

    @PostMapping("/admin/trip/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        service.deleteTrip(id);
        return "redirect:/";
    }
    @GetMapping("/admin/trip/add")
    public String addTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("stations", service.getAllStations());
        return "add-trip";
    }

    @PostMapping("/admin/trip/save")
    public String saveTrip(@ModelAttribute Trip trip) {
        service.saveTrip(trip);
        return "redirect:/";
    }
}