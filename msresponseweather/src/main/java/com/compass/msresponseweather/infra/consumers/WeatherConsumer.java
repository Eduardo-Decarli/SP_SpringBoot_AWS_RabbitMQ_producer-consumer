package com.compass.msresponseweather.infra.consumers;

import com.compass.msresponseweather.entities.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherConsumer {

    @GetMapping("/weather")
    WeatherResponse getWeather(@RequestParam("q") String city,
                               @RequestParam("appid") String apiKey,
                               @RequestParam("units") String units);
}
