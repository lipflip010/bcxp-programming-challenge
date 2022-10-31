package de.bcxp.challenge.weather;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DayMeasurement {

    private int dayOfTheMonth;

    private int minimumTemperature;

    private int maximumTemperature;

    public int getTemperatureSpread() {
        return maximumTemperature - minimumTemperature;
    }
}
