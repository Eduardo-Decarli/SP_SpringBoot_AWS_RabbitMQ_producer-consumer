package com.compass.msweatherAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Main {

    private double temp;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
}
