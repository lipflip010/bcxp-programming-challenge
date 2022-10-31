package de.bcxp.challenge;

public class InvalidDataSourceException extends Exception {
    public InvalidDataSourceException(String errorMessage) {
        super(errorMessage);
    }
}