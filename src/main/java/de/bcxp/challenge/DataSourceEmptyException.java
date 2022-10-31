package de.bcxp.challenge;

public class DataSourceEmptyException  extends Exception {
    public DataSourceEmptyException(String errorMessage) {
        super(errorMessage);
    }
}