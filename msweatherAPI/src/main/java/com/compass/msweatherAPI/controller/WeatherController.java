package com.compass.msweatherAPI.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return "ok";
    }
}
