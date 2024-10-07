package ru.merkulova.RestClientForWeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.merkulova.RestClientForWeatherApp.clients.MeasurementRestClient;

@SpringBootApplication
public class RestClientForWeatherAppApplication {

	public static void main(String[] args) {
		MeasurementRestClient measurementRestClient = new MeasurementRestClient();
		SpringApplication.run(RestClientForWeatherAppApplication.class, args);
		measurementRestClient.postMeasurement();
	}

}
