package com.compass.msresponseweather.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class WeatherSubscriber {

    @RabbitListener(queues = "${mq.queues.weather}")
    public void receivingRequest(@Payload String payload){
        System.out.println(payload);
    }
}
