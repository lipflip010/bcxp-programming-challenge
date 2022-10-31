package de.bcxp.challenge.country;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.InvalidDataSourceException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class CountryDataSourceCsvImpl implements CountryDataSource {

    private final String filePath;

    public CountryDataSourceCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Country> getCountries() throws InvalidDataSourceException {

        List<Country> countries;
        try {

            countries = new CsvToBeanBuilder<Country>(new FileReader(filePath))
                    .withType(Country.class).build().parse();
        } catch (FileNotFoundException e) {
            throw new InvalidDataSourceException(String.format("Error: File %s not found. %n", filePath));
        }

        return countries;
    }
}