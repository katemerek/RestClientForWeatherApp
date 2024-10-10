package com.github.katemerek.RestClientForWeatherApp;

import com.github.katemerek.RestClientForWeatherApp.clients.MeasurementRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientForWeatherAppApplication {

	public static void main(String[] args) {
		MeasurementRestClient measurementRestClient = new MeasurementRestClient();
		SpringApplication.run(RestClientForWeatherAppApplication.class, args);
		measurementRestClient.postRandomMeasurement();
	}
}
