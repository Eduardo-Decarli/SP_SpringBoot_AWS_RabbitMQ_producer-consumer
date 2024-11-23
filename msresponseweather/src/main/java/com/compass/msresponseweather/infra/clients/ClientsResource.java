package com.compass.msresponseweather.infra.clients;

import com.compass.msresponseweather.entities.City;
import com.compass.msresponseweather.entities.WeatherResponse;
import com.compass.msresponseweather.infra.consumers.WeatherConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class ClientsResource {

    private final WeatherConsumer weatherConsumer;

    private final String key = "5ab4f39a4b9d42aaff80eeffb3f63064";
    private final String unit = "metric";
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${mq.queues.weather}")
    public void consumeRequest(String response) {
        try {
            if(response == null) {
                log.error("Error receiving message");
            }
            City city = objectMapper.readValue(response, City.class);
            log.info("Message received successfully");
            log.info("searching weather in the " + city);
            WeatherResponse consumer = weatherConsumer.getWeather(city.getName(), key, unit);
            log.info(
                    "\n===========" + "\n" +
                    response + consumer + "\n");
        } catch(Exception e) {
            log.error("Error processing message, city's name is invalid");
        }
    }
}
