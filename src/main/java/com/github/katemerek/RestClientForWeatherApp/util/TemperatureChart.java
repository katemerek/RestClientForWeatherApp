package com.github.katemerek.RestClientForWeatherApp.util;

import com.github.katemerek.RestClientForWeatherApp.clients.MeasurementRestClient;
import com.github.katemerek.RestClientForWeatherApp.models.Measurement;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TemperatureChart {
    public static void main(String[] args) {
        MeasurementRestClient client = new MeasurementRestClient();
        List<Measurement> measurementListEx = client.getRequestForMeasurements();
        List<Double> temperatureList = measurementListEx.stream().map(Measurement::getValue).collect(Collectors.toUnmodifiableList());
        drawCharts(temperatureList);
    }

    private static void drawCharts(List<Double> temperatureList) {
        double[] XData = IntStream.range(0, temperatureList.size()).asDoubleStream().toArray();
        double[] YData = temperatureList.stream().mapToDouble(i -> i).toArray();
        XYChart chart = QuickChart.getChart("Temperature", "X", "Y", "y(x)", XData, YData);
        new SwingWrapper(chart).displayChart();
    }
}
