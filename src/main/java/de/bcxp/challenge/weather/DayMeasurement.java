package de.bcxp.challenge.weather;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayMeasurement {

    @CsvBindByName(column = "Day")
    private int dayOfTheMonth;

    @CsvBindByName(column = "MnT")
    private int minimumTemperature;

    @CsvBindByName(column = "MxT")
    private int maximumTemperature;

    public int getTemperatureSpread() {
        return maximumTemperature - minimumTemperature;
    }
}
