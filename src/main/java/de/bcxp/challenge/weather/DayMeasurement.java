package de.bcxp.challenge.weather;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DayMeasurement {

    @CsvBindByName(column = "Day")
    private int dayOfTheMonth;

    @CsvBindByName(column = "MxT")
    private int minimumTemperature;

    @CsvBindByName(column = "MnT")
    private int maximumTemperature;

    public int getTemperatureSpread() {
        return maximumTemperature - minimumTemperature;
    }
}
