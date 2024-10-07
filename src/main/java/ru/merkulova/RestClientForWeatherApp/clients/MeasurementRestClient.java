package ru.merkulova.RestClientForWeatherApp.clients;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import ru.merkulova.RestClientForWeatherApp.models.Measurement;
import ru.merkulova.RestClientForWeatherApp.models.Sensor;
import ru.merkulova.RestClientForWeatherApp.util.SensorsEnum;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class MeasurementRestClient {

    public void postMeasurement() {
        RestClient restClient = RestClient.create();
        Measurement measurement = new Measurement(temperature(), rain(), new Sensor(sensorType()));
        ResponseEntity<Void> responseAddMeasurement = restClient.post()
                .uri("http://localhost:8080/measurements/add")
                .contentType(APPLICATION_JSON)
                .body(measurement)
                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
//                    throw new NotFoundException(response.getStatusCode(), response.getHeaders());
//                })
                .toBodilessEntity();
        System.out.println("Measurement added: " + measurement);
    }
    public void getRequestForMeasurements () {
        RestClient restClient = RestClient.create();
        List <Measurement> measurements = restClient.get()
                .uri("http://localhost:8080/measurements")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Measurement>>() {});
        System.out.println(measurements);
    }

    public void getCountRainyDays () {
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri("http://localhost:8080/measurements/rainyDaysCount")
                .retrieve()
                .body(String.class);
        System.out.println(result);
    }

    public double temperature(){
        double minTemperature = -30.0;
        double maxTemperature = 40.0;
        return minTemperature + new Random().nextDouble() * (maxTemperature - minTemperature);
    }

    public boolean rain() {
        return new Random().nextBoolean();
    }
    public String sensorType (){
        Random random = new Random();
        SensorsEnum[] values = SensorsEnum.values();
        int size=values.length;
        String sensorRandom = String.valueOf(values[random.nextInt(size)]);
        return sensorRandom;
        }
    }

