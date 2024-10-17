# Rest client for Weather App
## Description
This project is a small app for hand-testing restful service WeatherApp.

### Steps to run the application
- Run the WeatherApp.
- Clone the application. The client will start running at <http://localhost:9090>.

- Registration [new sensor] (com/github/katemerek/RestClientForWeatherApp/clients/SensorRestClient.java):
```
Sensor sensor = new Sensor("sensor_name"); 
```
- Add a [new measurement] (com/github/katemerek/RestClientForWeatherApp/clients/MeasurementRestClient.java):
```
 Measurement measurement = new Measurement(22.5, true, new Sensor("sensor_alfa"));
```
- Or use a `MeasurementRestClient.postRandomMeasurement()` for testing API). Attention: the list of registered sensors must match with [Sensors Enum] (com/github/katemerek/RestClientForWeatherApp/util/SensorsEnum.java);
- You can also see a table of [all measurements] (MeasurementRestClient.getRequestForMeasurements ()), the [number of rainy days] (MeasurementRestClient.getCountRainyDays ()) and [draw] a chart of temperature changes (com/github/katemerek/RestClientForWeatherApp/util/TemperatureChart.java).
#### Measurement parameters
- air temperature (value, double),
- is it raining outside (raining),
- name of the sensor that recorded the measurement (sensor).