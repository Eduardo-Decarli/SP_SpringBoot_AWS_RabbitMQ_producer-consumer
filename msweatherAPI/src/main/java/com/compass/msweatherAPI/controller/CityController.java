package com.compass.msweatherAPI.controller;

import com.compass.msweatherAPI.entities.City;
import com.compass.msweatherAPI.entities.ProtocolRequired;
import com.compass.msweatherAPI.services.WeatherServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class CityController {

    private final WeatherServices services;

    @PostMapping
    public String requestWeather(@RequestBody City city) throws JsonProcessingException {
        services.requestCity(city);
        ProtocolRequired protocol = services.issuanceRequest();
        return "Weather forecast request for the city " + city.getName() + " has been sent | Your protocol is " + protocol;
    }


}
