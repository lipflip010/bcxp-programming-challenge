package de.bcxp.challenge.country;

import de.bcxp.challenge.InvalidDataSourceException;

import java.util.List;

public interface CountryDataSource {

    List<Country> getCountries() throws InvalidDataSourceException;
}
