package ru.merkulova.RestClientForWeatherApp.clients;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import ru.merkulova.RestClientForWeatherApp.models.Sensor;
import ru.merkulova.RestClientForWeatherApp.util.NotFoundException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class SensorRestClient {

    public void postNewSensor() {
        RestClient restClient = RestClient.create();
        Sensor sensor = new Sensor("sensor_epsilon");
        ResponseEntity<Void> responseSensor = restClient.post()
                .uri("http://localhost:8080/sensors/registration")
                .contentType(APPLICATION_JSON)
                .body(sensor)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new NotFoundException(response.getStatusCode(), response.getHeaders());
                })
                .toBodilessEntity();
        System.out.println(responseSensor.getStatusCode());
    }
}
