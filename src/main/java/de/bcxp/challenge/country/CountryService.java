package de.bcxp.challenge.country;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public String getCountryWithHighestPopulationDensity() throws InvalidDataSourceException {
        List<Country> countryList = countryRepository.getCountries();

        ArrayList<Country> countries = new ArrayList<>(countryList);
        countries.sort(Comparator.comparing(Country::getPopulationDensity));
        Collections.reverse(countries);
        Country highestDensityCountry = countries.get(0);
        System.out.printf(
                "[CountryService] Country with highest population density: Name %s Density: %f%n",
                highestDensityCountry.getName(),
                highestDensityCountry.getPopulationDensity());
        return highestDensityCountry.getName();
    }
}
