package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WeatherDataSourceCsvImplTest {
    private WeatherDataSourceCsvImpl sut;

    @BeforeEach
    void setup() {
        sut = new WeatherDataSourceCsvImpl("src/test/resources/weatherTest.csv");
    }

    @Test
    @DisplayName("should read csv and map data to beans")
    void getDayMeasurements() throws InvalidDataSourceException {
        List<DayMeasurement> result = sut.getDayMeasurements();

        DayMeasurement dayMeasurement1 = DayMeasurement.builder().dayOfTheMonth(1).maximumTemperature(40).minimumTemperature(20).build();
        DayMeasurement dayMeasurement2 = DayMeasurement.builder().dayOfTheMonth(2).maximumTemperature(30).minimumTemperature(10).build();
        List<DayMeasurement> expected = List.of(dayMeasurement1, dayMeasurement2);

        assertThat(expected).hasSameSizeAs(result);


        RecursiveComparisonConfiguration configuration = RecursiveComparisonConfiguration.builder()
                .build();

        assertThat(result).usingRecursiveFieldByFieldElementComparator(configuration)
                .contains(dayMeasurement1);

        assertThat(result).usingRecursiveFieldByFieldElementComparator(configuration)
                .contains(dayMeasurement2);

        assertThat(result).hasSameSizeAs(expected);
    }
}