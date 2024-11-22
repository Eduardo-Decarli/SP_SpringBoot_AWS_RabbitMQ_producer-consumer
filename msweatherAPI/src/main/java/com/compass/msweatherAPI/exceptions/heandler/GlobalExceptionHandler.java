package com.compass.msweatherAPI.exceptions.heandler;

import com.compass.msweatherAPI.exceptions.ErrorConectionRefused;
import com.compass.msweatherAPI.exceptions.ErrorRecivingCity;
import com.compass.msweatherAPI.exceptions.ErrorRequiredProtocol;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorConectionRefused.class)
    public ResponseEntity<ErrorMessage> errorConectionRefused(ErrorConectionRefused ex,
                                                               HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(ErrorRecivingCity.class)
    public ResponseEntity<ErrorMessage> errorRecivingCity(ErrorRecivingCity ex,
                                                              HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(ErrorRequiredProtocol .class)
    public ResponseEntity<ErrorMessage> errorRequiredProtocol(ErrorRequiredProtocol ex,
                                                          HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
