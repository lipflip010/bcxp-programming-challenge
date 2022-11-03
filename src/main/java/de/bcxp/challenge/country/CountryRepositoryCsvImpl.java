package de.bcxp.challenge.country;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.InvalidDataSourceException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class CountryRepositoryCsvImpl implements CountryRepository {

    private final String filePath;

    public CountryRepositoryCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Country> getCountries() throws InvalidDataSourceException {

        List<Country> countries;
        try {

            countries = new CsvToBeanBuilder<Country>(new FileReader(filePath))
                    .withSeparator(';')
                    .withType(Country.class).build().parse();
        } catch (FileNotFoundException e) {
            throw new InvalidDataSourceException(String.format("Error: File %s not found. %n", filePath));
        }
        System.out.printf("[CountryRepositoryCsvImpl] Read %d countries from file %s%n",countries.size(), filePath );
        return countries;
    }
}