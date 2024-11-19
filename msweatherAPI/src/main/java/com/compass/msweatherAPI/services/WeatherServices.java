package com.compass.msweatherAPI.services;

import com.compass.msweatherAPI.entities.City;
import com.compass.msweatherAPI.mqueue.RequestWeather;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServices {

    private final RequestWeather request;

    public void requestCity(City city) throws JsonProcessingException {
            request.requestWeather(city);
    }
}
