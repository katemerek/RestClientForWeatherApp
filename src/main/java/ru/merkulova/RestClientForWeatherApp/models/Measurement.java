package ru.merkulova.RestClientForWeatherApp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.merkulova.RestClientForWeatherApp.util.SensorsEnum;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Measurement implements Serializable {
        private Double value;

        private Boolean raining;

        private SensorsEnum sensor;

        public Measurement(Double value, Boolean raining, SensorsEnum sensor) {
                this.value = value;
                this.raining = raining;
                this.sensor = sensor;
        }

}
