package com.compass.msweatherAPI.mqueue;

import com.compass.msweatherAPI.entities.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestWeather {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueRequestWeather;

    public void requestWeather(City city) throws JsonProcessingException {
        var json = convertIntoJson(city);
        rabbitTemplate.convertAndSend(queueRequestWeather.getName(), json);
    }

    private String convertIntoJson(City city) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(city);
        return json;
    }
}
