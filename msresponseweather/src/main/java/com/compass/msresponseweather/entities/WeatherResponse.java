package com.compass.msresponseweather.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponse {

    private Main main;
    private List<Weather> weather;

    @Override
    public String toString() {
        String template = "\n===========" +
                "\nTemp: " + main.getTemp() +
                "\nMin_temp: " + main.getTemp_min() +
                "\nMax_temp: " + main.getTemp_max() +
                "\nPressure: " + main.getPressure() +
                "\nHumidity: " + main.getHumidity();

        for(Weather x: weather) {
            return template +
                    "\nWeather: " + x.getMain() +
                    "\nDescription: " + x.getDescription();
        }
        return template;
    }
}
