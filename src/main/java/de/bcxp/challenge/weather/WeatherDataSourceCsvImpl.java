package de.bcxp.challenge.weather;

import java.util.List;

public class WeatherDataSourceCsvImpl implements WeatherDataSource {
    @Override
    public List<DayMeasurement> getDayMeasurements() {
        DayMeasurement dayMeasurement1 = DayMeasurement.builder().dayOfTheMonth(5).minimumTemperature(40).maximumTemperature(70).build();
        DayMeasurement dayMeasurement2 = DayMeasurement.builder().dayOfTheMonth(7).minimumTemperature(30).maximumTemperature(80).build();

        return List.of(dayMeasurement1,dayMeasurement2);
    }
}
