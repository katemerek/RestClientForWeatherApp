package ru.merkulova.RestClientForWeatherApp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class NotFoundException extends RuntimeException {

    public NotFoundException(HttpStatusCode statusCode, HttpHeaders headers, String message) {
        super(String.format("%s %s %s", statusCode, headers, message));
    }
}
