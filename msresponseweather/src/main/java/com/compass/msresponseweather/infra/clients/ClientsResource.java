package com.compass.msresponseweather.infra.clients;

import com.compass.msresponseweather.entities.WeatherResponse;
import com.compass.msresponseweather.infra.consumers.WeatherConsumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientsResource {

    private final WeatherConsumer weatherConsumer;

    private final String key = "5ab4f39a4b9d42aaff80eeffb3f63064";
    private final String unit = "metric";

    public void consumeRequest(String city) {
        log.info("Sourch weather in the " + city);
        WeatherResponse consumer = weatherConsumer.getWeather(city, key, unit);
        System.out.println(consumer);
    }
}
