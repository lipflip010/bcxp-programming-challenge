package de.bcxp.challenge;

import de.bcxp.challenge.weather.WeatherDataSourceCsvImpl;
import de.bcxp.challenge.weather.WeatherService;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        WeatherDataSourceCsvImpl weatherDataSourceCsv = new WeatherDataSourceCsvImpl("src/main/resources/de/bcxp/challenge/weather.csv");
        WeatherService weatherService = new WeatherService(weatherDataSourceCsv);

        int dayWithSmallestTempSpread;   // Your day analysis function call …
        try {
            dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread();
            System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);
        } catch (DataSourceEmptyException e) {
            System.out.printf(e.getMessage());
        }


        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
