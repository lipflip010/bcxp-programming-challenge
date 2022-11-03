package de.bcxp.challenge.country;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.List;

public interface CountryRepository {

    List<Country> getCountries() throws InvalidDataSourceException;
}
