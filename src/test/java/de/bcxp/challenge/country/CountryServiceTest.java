package de.bcxp.challenge.country;

import de.bcxp.challenge.InvalidDataSourceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CountryServiceTest {

    private final CountryDataSource countryDataSource = Mockito.mock(CountryDataSource.class);
    private CountryService sut;

    @BeforeEach
    void setup() {
        sut = new CountryService(countryDataSource);
    }

    @Test
    @DisplayName("should return name of country with highest population density")
    void getCountryWithHighestPopulationDensity() throws InvalidDataSourceException {

        Country country1 = Country.builder().name("Germany").population(500).area(100).build();
        Country country2 = Country.builder().name("Brazil").population(500).area(50).build();
        Country country3 = Country.builder().name("UK").population(500).area(75).build();
        Country country4 = Country.builder().name("US").population(500).area(25).build();
        Country country5 = Country.builder().name("China").population(500).area(1).build();
        Country country6 = Country.builder().name("India").population(500).area(500).build();
        List<Country> mockReturn = List.of(country1, country2, country3, country4, country5, country6);

        when(countryDataSource.getCountries()).thenReturn(mockReturn);

        assertEquals("China", sut.getCountryWithHighestPopulationDensity());
    }

}