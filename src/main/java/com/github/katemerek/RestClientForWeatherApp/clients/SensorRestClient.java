package com.github.katemerek.RestClientForWeatherApp.clients;

import com.github.katemerek.RestClientForWeatherApp.models.Sensor;
import com.github.katemerek.RestClientForWeatherApp.util.NotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class SensorRestClient {

    public void postNewSensor() {
        RestClient restClient = RestClient.create();
        Sensor sensor = new Sensor("sensor_psi");
        ResponseEntity<Void> responseSensor = restClient.post()
                .uri("http://localhost:8080/sensors/registration")
                .contentType(APPLICATION_JSON)
                .body(sensor)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new NotFoundException(response.getStatusCode(), response.getHeaders(), "Error posting new sensor");
                })
                .toBodilessEntity();
        System.out.println(responseSensor.getStatusCode());
    }
}
