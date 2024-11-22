package com.compass.msweatherAPI.exceptions;

public class ErrorRecivingCity extends RuntimeException {
    public ErrorRecivingCity(String message) {
        super(message);
    }
}
