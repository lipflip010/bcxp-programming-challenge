package de.bcxp.challenge.weather;

public class WeatherService {
    private final WeatherDataSource weatherDataSource;


    public WeatherService(WeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
    }


    public String getDayWithSmallestTempSpread() {
        return weatherDataSource.getDayMeasurements();
    }

}
