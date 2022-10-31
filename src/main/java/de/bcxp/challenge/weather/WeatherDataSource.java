package de.bcxp.challenge.weather;

import java.util.List;

public interface WeatherDataSource {

    List<DayMeasurement> getDayMeasurements();
}
