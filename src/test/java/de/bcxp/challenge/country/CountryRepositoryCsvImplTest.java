package de.bcxp.challenge.country;

import de.bcxp.challenge.InvalidDataSourceException;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryRepositoryCsvImplTest {

    @Test
    @DisplayName("should read csv and map data to beans")
    void getCountries() throws InvalidDataSourceException {
        CountryRepositoryCsvImpl sut = new CountryRepositoryCsvImpl("src/test/resources/countryTest.csv");
        List<Country> result = sut.getCountries();

        Country country1 = Country.builder().name("Test").area(10).population(200).build();
        Country country2 = Country.builder().name("Test2").area(20).population(400).build();

        List<Country> expected = List.of(country1, country2);

        assertThat(expected).hasSameSizeAs(result);


        RecursiveComparisonConfiguration configuration = RecursiveComparisonConfiguration.builder()
                .build();

        assertThat(result).usingRecursiveFieldByFieldElementComparator(configuration)
                .contains(country1);

        assertThat(result).usingRecursiveFieldByFieldElementComparator(configuration)
                .contains(country2);

    }

    @Test
    @DisplayName("should throw exception if file not found")
    void getCountriesThrows() {
        String filePath = "src/test/resources/notfound.csv";
        CountryRepositoryCsvImpl sut = new CountryRepositoryCsvImpl(filePath);
        Exception exception = assertThrows(InvalidDataSourceException.class, sut::getCountries);

        assertEquals(String.format("Error: File %s not found. %n", filePath), exception.getMessage());
    }
}