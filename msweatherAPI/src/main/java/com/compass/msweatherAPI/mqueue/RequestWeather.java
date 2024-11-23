package com.compass.msweatherAPI.mqueue;

import com.compass.msweatherAPI.entities.City;
import com.compass.msweatherAPI.exceptions.ErrorConectionRefused;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class RequestWeather {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueRequestWeather;

    public void requestWeather(City city) throws JsonProcessingException {
        try{
        var json = convertIntoJson(city);
        rabbitTemplate.convertAndSend(queueRequestWeather.getName(), json);
        } catch(AmqpConnectException e) {
            log.error("Connection refused for queue");
            throw new ErrorConectionRefused("There was an error connecting to the queue");
        }
    }

    private String convertIntoJson(City city) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(city);
        log.info("The city object was successfully converted to JSON");
        return json;
    }
}
