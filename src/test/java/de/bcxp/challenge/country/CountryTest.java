package de.bcxp.challenge.country;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

    @Test
    @DisplayName("should calculate population density")
    void getPopulationDensity() {
        Country country = Country.builder().population(100).area(3).build();

        assertEquals(33.33333206176758, country.getPopulationDensity());
    }

}