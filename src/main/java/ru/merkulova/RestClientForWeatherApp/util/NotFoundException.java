package ru.merkulova.RestClientForWeatherApp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(HttpStatusCode statusCode, HttpHeaders headers) {
    }
}
