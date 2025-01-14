package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeatherService {
    private final WeatherRepository weatherRepository;


    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    public int getDayWithSmallestTempSpread() throws InvalidDataSourceException {
        List<DayMeasurement> dayMeasurementList = weatherRepository.getDayMeasurements();

        ArrayList<DayMeasurement> dayMeasurements = new ArrayList<>(dayMeasurementList);
        dayMeasurements.sort(Comparator.comparing(DayMeasurement::getTemperatureSpread));

        DayMeasurement minimumSpreadMeasurement = dayMeasurements.get(0);
        System.out.printf("[WeatherService] Day with smallest spread: Day %d Spread: %d%n", minimumSpreadMeasurement.getDayOfTheMonth(), minimumSpreadMeasurement.getTemperatureSpread());
        return minimumSpreadMeasurement.getDayOfTheMonth();
    }

}
