package de.bcxp.challenge.weather;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.InvalidDataSourceException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class WeatherRepositoryCsvImpl implements WeatherRepository {

    private final String filePath;

    public WeatherRepositoryCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<DayMeasurement> getDayMeasurements() throws InvalidDataSourceException {

        List<DayMeasurement> dayMeasurements;
        try {
            dayMeasurements = new CsvToBeanBuilder<DayMeasurement>(new FileReader(filePath))
                    .withType(DayMeasurement.class)
                    .build().parse();
        } catch (FileNotFoundException e) {
            throw new InvalidDataSourceException(String.format("Error: File %s not found. %n", filePath));
        }

        return dayMeasurements;
    }
}
