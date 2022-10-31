package de.bcxp.challenge.weather;

import de.bcxp.challenge.DataSourceEmptyException;

import java.util.List;

public interface WeatherDataSource {

    List<DayMeasurement> getDayMeasurements() throws DataSourceEmptyException;
}
