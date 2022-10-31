package de.bcxp.challenge.weather;

import de.bcxp.challenge.DataSourceEmptyException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeatherService {
    private final WeatherDataSource weatherDataSource;


    public WeatherService(WeatherDataSource weatherDataSource) {
        this.weatherDataSource = weatherDataSource;
    }


    public int getDayWithSmallestTempSpread() throws DataSourceEmptyException {
        List<DayMeasurement> dayMeasurementList = weatherDataSource.getDayMeasurements();

        ArrayList<DayMeasurement> dayMeasurements = new ArrayList<>(dayMeasurementList);
        dayMeasurements.sort(Comparator.comparing(DayMeasurement::getTemperatureSpread));
        return dayMeasurements.get(0).getDayOfTheMonth();
    }

}
