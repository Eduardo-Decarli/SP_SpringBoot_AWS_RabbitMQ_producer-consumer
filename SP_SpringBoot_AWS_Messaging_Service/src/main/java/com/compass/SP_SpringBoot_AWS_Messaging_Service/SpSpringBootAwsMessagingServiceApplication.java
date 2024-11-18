package com.compass.SP_SpringBoot_AWS_Messaging_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpSpringBootAwsMessagingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpSpringBootAwsMessagingServiceApplication.class, args);
	}

}
