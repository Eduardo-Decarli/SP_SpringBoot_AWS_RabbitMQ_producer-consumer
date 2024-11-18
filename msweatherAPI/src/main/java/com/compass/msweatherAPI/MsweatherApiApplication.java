package com.compass.msweatherAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsweatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsweatherApiApplication.class, args);
	}

}
