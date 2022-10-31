package de.bcxp.challenge.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    private final WeatherDataSource weatherDataSource = Mockito.mock(WeatherDataSource.class);
    private WeatherService sut;

    @BeforeEach
    void setup() {
        sut = new WeatherService(weatherDataSource);
    }

    @Test
    @DisplayName("should return day with the smallest temperature spread")
    void getDayWithSmallestTempSpread() {
        DayMeasurement dayMeasurement1 = DayMeasurement.builder().dayOfTheMonth(5).minimumTemperature(40).maximumTemperature(70).build();
        DayMeasurement dayMeasurement2 = DayMeasurement.builder().dayOfTheMonth(7).minimumTemperature(30).maximumTemperature(80).build();
        DayMeasurement dayMeasurement3 = DayMeasurement.builder().dayOfTheMonth(1).minimumTemperature(79).maximumTemperature(80).build();
        DayMeasurement dayMeasurement4 = DayMeasurement.builder().dayOfTheMonth(20).minimumTemperature(21).maximumTemperature(80).build();
        List<DayMeasurement> mockReturn =  List.of(dayMeasurement1,dayMeasurement2, dayMeasurement3, dayMeasurement4);

        when(weatherDataSource.getDayMeasurements()).thenReturn(mockReturn);

        assertEquals(1, sut.getDayWithSmallestTempSpread());

    }
}