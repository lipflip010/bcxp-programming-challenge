package de.bcxp.challenge.weather;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayMeasurementTest {

    @Test
    @DisplayName("should calculate correct spread for correct positive inputs")
    void testGetTemperatureSpread1() {
        DayMeasurement dayMeasurement = DayMeasurement.builder().minimumTemperature(50).maximumTemperature(70).build();
        assertEquals(20, dayMeasurement.getTemperatureSpread());
    }

    @Test
    @DisplayName("should calculate correct spread for correct negative inputs")
    void testGetTemperatureSpread2() {
        DayMeasurement dayMeasurement = DayMeasurement.builder().minimumTemperature(-20).maximumTemperature(70).build();
        assertEquals(90, dayMeasurement.getTemperatureSpread());
    }

}