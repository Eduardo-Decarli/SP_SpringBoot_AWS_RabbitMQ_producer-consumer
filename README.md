# Require Weather Project

This project performs requests and retrieves weather forecasts through the integration between a producer and a consumer connected to a private OpenWeatherMap API. The project is built using a microservices architecture and RabbitMQ for asynchronous communication between the microservices.

## Architecture

The application consists of the following services:

- **msweatherAPI**
    - Receives weather forecast requests via POST.
    - Sends weather forecast requests to the RabbitMQ queue.
    - Integrates with RabbitMQ to enqueue messages.
    - Logs errors and issues related to its operation.

- **msresponseweather**
    - Consumes messages from the RabbitMQ queue.
    - Uses OpenFeign to integrate with the OpenWeatherMap API and process weather data.
    - Logs the weather forecast response.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Cloud
- Spring AMQP
- Spring OpenFeign
- Spring Eureka
- RabbitMQ
- Postman
- Docker
- Git
- GitHub

## Execution Flow

Once the microservices are running, msweatherAPI will be available on port **8080** at the endpoint **localhost:8080/weather**.

1. msweatherAPI receives a JSON object containing the name of a city.
2. msweatherAPI sends a message with the city name to the weather queue in RabbitMQ.
3. msresponseweather consumes the message from the queue, calls the OpenWeatherMap API via OpenFeign, and processes the weather data.
4. The processed response is logged in the msresponseweather microservice logs.

## How to Use

1. Pull or clone the project to a local folder.

2. Open a terminal and execute the following command: **docker-compose up -d**. This will download and run the required project images (RabbitMQ, msweather, and msresponseweather).

3. Once the containers are running, navigate to **http://localhost:15672/#/queues** and create a new queue named **weather**. The name must match exactly for the services to locate the queue.

4. Open Postman and import the **CityCollection** file to access the POST route for sending a city name to the API. You can specify the city in the request body.

5. Click **Send** in Postman to generate a request protocol.

6. To view the processed information, check the logs of the **msresponseweather** container using the Docker command **"docker logs msresponseweather"**. The weather information for the specified city will be displayed. If an error occurs, stop the msresponseweather container and restart it using Docker Desktop or the **Docker stop/start commands**.

Stop the consumer container: **docker stop msresponseweather**
Start the consumer container: **docker start msresponseweather**