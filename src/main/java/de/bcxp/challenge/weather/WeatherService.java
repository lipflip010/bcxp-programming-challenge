package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeatherService {
    private final WeatherDataSource weatherDataSource;


    public WeatherService(WeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
    }


    public int getDayWithSmallestTempSpread() throws InvalidDataSourceException {
        List<DayMeasurement> dayMeasurementList = weatherDataSource.getDayMeasurements();

        ArrayList<DayMeasurement> dayMeasurements = new ArrayList<>(dayMeasurementList);
        dayMeasurements.sort(Comparator.comparing(DayMeasurement::getTemperatureSpread));

        DayMeasurement minimumSpreadMeasurement = dayMeasurements.get(0);
        System.out.printf("WeatherService - getDayWithSmallestTempSpread: Day %d Spread: %d%n", minimumSpreadMeasurement.getDayOfTheMonth(), minimumSpreadMeasurement.getTemperatureSpread());
        return minimumSpreadMeasurement.getDayOfTheMonth();
    }

}
