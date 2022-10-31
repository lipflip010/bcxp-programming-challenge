package de.bcxp.challenge.weather;

import java.util.ArrayList;
import java.util.Comparator;

public class WeatherService {
    private final WeatherDataSource weatherDataSource;


    public WeatherService(WeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
    }


    public int getDayWithSmallestTempSpread() {
        ArrayList<DayMeasurement> dayMeasurements = new ArrayList<>(weatherDataSource.getDayMeasurements());
        dayMeasurements.sort(Comparator.comparing(DayMeasurement::getTemperatureSpread));
        return dayMeasurements.get(0).getDayOfTheMonth();
    }

}
