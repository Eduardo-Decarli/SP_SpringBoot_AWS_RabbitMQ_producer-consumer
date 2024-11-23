package com.compass.msweatherAPI.services;

import com.compass.msweatherAPI.entities.City;
import com.compass.msweatherAPI.entities.ProtocolRequired;
import com.compass.msweatherAPI.exceptions.ErrorRecivingCity;
import com.compass.msweatherAPI.exceptions.ErrorRequiredProtocol;
import com.compass.msweatherAPI.mqueue.RequestWeather;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class WeatherServices {

    private final RequestWeather request;

    public void requestCity(City city) throws JsonProcessingException {
        if(city == null) {
            log.error("the receiving city is null");
            throw new ErrorRecivingCity("Error receiving city data");
        }
        request.requestWeather(city);
        log.info("Weather request completed");
    }

    public ProtocolRequired issuanceRequest() {
        try {
            var protocol = UUID.randomUUID().toString();
            log.info("Generated time protocol");
            return new ProtocolRequired(protocol);
        } catch(Exception e) {
            log.error("Error generating protocol");
            throw new ErrorRequiredProtocol("Unable to generate protocol");
        }
    }
}
