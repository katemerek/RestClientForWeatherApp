package ru.merkulova.RestClientForWeatherApp.clients;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import ru.merkulova.RestClientForWeatherApp.models.Measurement;
import ru.merkulova.RestClientForWeatherApp.models.MeasurementsResponse;
import ru.merkulova.RestClientForWeatherApp.models.Sensor;
import ru.merkulova.RestClientForWeatherApp.util.NotFoundException;
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
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new NotFoundException(response.getStatusCode(), response.getHeaders(), "Error posting new measurement");
                })
                .toBodilessEntity();
        System.out.println("Measurement added: " + measurement);
    }
    public List<Measurement> getRequestForMeasurements () {
        RestClient restClient = RestClient.create();
        MeasurementsResponse measurements = restClient.get()
                .uri("http://localhost:8080/measurements")
                .retrieve()
                .body(MeasurementsResponse.class);
        System.out.println(measurements);
        if (measurements.getMeasurements().isEmpty()) {return  Collections.emptyList();}
        return measurements.getMeasurements();
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

