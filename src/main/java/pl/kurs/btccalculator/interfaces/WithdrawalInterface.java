package pl.kurs.btccalculator.interfaces;

import pl.kurs.btccalculator.exceptions.InvalidCurrencyNameException;
import pl.kurs.btccalculator.exceptions.NoConnectionException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public interface WithdrawalInterface {

    BigDecimal withdraw(LocalDate date, String currencyFrom, BigDecimal amountOfCash) throws InvalidCurrencyNameException, IOException, NoConnectionException, DateTimeParseException;
}
