package com.github.katemerek.RestClientForWeatherApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor implements Serializable {
    private String name;
}
