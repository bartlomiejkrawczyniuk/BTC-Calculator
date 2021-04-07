package pl.kurs.btccalculator.interfaces;


import pl.kurs.btccalculator.exceptions.InvalidCurrencyNameException;
import pl.kurs.btccalculator.exceptions.NoConnectionException;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface GetRateFromUrlInterface {

    BigDecimal getHistoricalBtcRateFromUrl(String currencyParameter, LocalDate date) throws InvalidCurrencyNameException, NoConnectionException;

    BigDecimal getActualBtcRateFromUrl(String currencyParameter) throws NoConnectionException, InvalidCurrencyNameException;
}
