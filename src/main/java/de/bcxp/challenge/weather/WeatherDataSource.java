package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.List;

public interface WeatherDataSource {

    List<DayMeasurement> getDayMeasurements() throws InvalidDataSourceException;
}
