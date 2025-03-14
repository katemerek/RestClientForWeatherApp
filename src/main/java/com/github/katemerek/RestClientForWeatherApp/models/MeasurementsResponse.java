package com.github.katemerek.RestClientForWeatherApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementsResponse {
    private List<Measurement> measurements;
}
