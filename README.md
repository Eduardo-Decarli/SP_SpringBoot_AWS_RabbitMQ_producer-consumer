# Require Weather Project

Este projeto realiza solicitações e recebimento de previsão do tempo através de um ecosistema de microserviços e integração com uma API privada da **OpenWeatherMap**. Foi utilizado uma arquitetura ms para realizar os projetos e o uso de mensageria **RabbitMQ** para a comunicação assincrona entre os microserviços.

## Arquitetura
A aplicação é composta pelos seguintes microserviços:

- **SP_SpringBoot_AWS_Messaging_Service**
    - Sobe o servidor Eureka para gerenciar a distribuição entre os microserviços

-  **mscloudgateway**
    - Gerencia uma porta fixa (8080) para poder acessar a aplicação msweatherAPI que está rodando em portas aleatórias
    - Faz um loadbalance entre aplicações msweatherAPI

- **msweatherAPI**
    - Recebe solicitação de previsão do tempo via POST
    - Envia solicitações de previsão do tempo para a fila RabbitMQ.
    - Integra com o RabbitMQ para colocar as mensagens na fila.
    - Apresenta erros e logs referente a problemas no funcionamento

- **msresponseweather**
    - Consome as mensagens da fila RabbitMQ.
    - Utiliza o OpenFeign para integrar-se à API do OpenWeatherMap e processar as informações meteorológicas.
    - Retorna no próprio log uma previsão do tempo.

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

## Fluxo de Execução
Ao iniciar os microserviços, o **msweatherAPI** estará associado a porta **8080** na rota **localhost:8080/weather**.

1. O msweatherAPI recebe um objeto JSON com o nome de uma cidade.
2. O msweatherAPI envia uma mensagem com o nome da cidade para a fila weather no RabbitMQ.
3. O msresponseweather consome a mensagem da fila, chama a API do OpenWeatherMap via OpenFeign, e processa os dados meteorológicos.
4. A resposta processada é exposta no log do microserviço **msresponseweather**.
