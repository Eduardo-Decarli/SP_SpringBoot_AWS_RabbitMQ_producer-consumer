package com.compass.msweatherAPI;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsweatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsweatherApiApplication.class, args);
	}

}
