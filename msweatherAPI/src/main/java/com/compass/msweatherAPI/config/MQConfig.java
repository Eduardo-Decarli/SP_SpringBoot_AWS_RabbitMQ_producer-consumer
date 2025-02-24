package com.compass.msweatherAPI.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.weather}")
    private String requestWeatherqueue;

    @Bean
    public Queue queueRequestWeather() {
        return new Queue(requestWeatherqueue, true);
    }
}
