package ru.merkulova.RestClientForWeatherApp.models;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measurement implements Serializable {
        private Double value;

        private Boolean raining;

        private Sensor sensor;

}
