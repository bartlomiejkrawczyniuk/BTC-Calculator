package pl.kurs.btccalculator.exceptions;

public class InvalidCurrencyNameException extends Exception{
    public InvalidCurrencyNameException(String message) {
        super(message);
    }
}
