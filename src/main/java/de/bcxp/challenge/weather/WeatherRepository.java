package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.List;

public interface WeatherRepository {

    List<DayMeasurement> getDayMeasurements() throws InvalidDataSourceException;
}
