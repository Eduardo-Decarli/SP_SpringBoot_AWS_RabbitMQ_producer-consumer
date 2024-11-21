package com.compass.msweatherAPI.exceptions;

public class ErrorRequiredProtocol extends RuntimeException{
    public ErrorRequiredProtocol(String message) {
        super(message);
    }
}
