package com.compass.msweatherAPI.exceptions;

public class ErrorConectionRefused extends RuntimeException {
    public ErrorConectionRefused(String message) {
        super(message);
    }
}

