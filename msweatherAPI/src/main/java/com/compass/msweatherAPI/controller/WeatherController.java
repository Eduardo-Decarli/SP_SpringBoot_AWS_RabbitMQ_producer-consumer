package com.compass.msweatherAPI.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
@Slf4j
public class WeatherController {

    @GetMapping
    public String status() {
        log.info("Status returned ok");
        return "ok";
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return "ok";
    }
}
