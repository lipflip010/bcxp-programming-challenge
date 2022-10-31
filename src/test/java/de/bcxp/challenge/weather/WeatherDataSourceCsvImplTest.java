package de.bcxp.challenge.weather;

import de.bcxp.challenge.InvalidDataSourceException;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WeatherDataSourceCsvImplTest {

    @Test
    @DisplayName("should read csv and map data to beans")
    void getDayMeasurements() throws InvalidDataSourceException {
        WeatherDataSourceCsvImpl sut = new WeatherDataSourceCsvImpl("src/test/resources/weatherTest.csv");
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

    @Test
    @DisplayName("should throw exception if file not found")
    void getDayMeasurementsThrows() {
        String filePath = "src/test/resources/notfound.csv";
        WeatherDataSourceCsvImpl sut = new WeatherDataSourceCsvImpl(filePath);
        Exception exception = assertThrows(InvalidDataSourceException.class, sut::getDayMeasurements);

        assertEquals(String.format("Error: File %s not found. %n", filePath), exception.getMessage());
    }
}