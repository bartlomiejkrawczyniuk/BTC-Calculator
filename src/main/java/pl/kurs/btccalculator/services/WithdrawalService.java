package pl.kurs.btccalculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.btccalculator.dao.BtcExchangeLogDAO;
import pl.kurs.btccalculator.exceptions.InvalidCurrencyNameException;
import pl.kurs.btccalculator.exceptions.NoConnectionException;
import pl.kurs.btccalculator.interfaces.GetRateFromUrlInterface;
import pl.kurs.btccalculator.interfaces.WithdrawalInterface;
import pl.kurs.btccalculator.model.AbstractBtcExchangeLog;
import pl.kurs.btccalculator.model.BtcExchangeLog;
import pl.kurs.btccalculator.utils.AnnoyanceCalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
@Service
public class WithdrawalService implements WithdrawalInterface {

    private final GetRateFromUrlInterface getRateFromUrl;
    private final BtcExchangeLogDAO btcExchangeLog;
    private final AnnoyanceCalc annoyanceCalc;

    @Autowired
    public WithdrawalService(GetRateFromUrlInterface getRateFromUrl, BtcExchangeLogDAO btcExchangeLog, AnnoyanceCalc annoyanceCalc) {
        this.getRateFromUrl = getRateFromUrl;
        this.btcExchangeLog = btcExchangeLog;
        this.annoyanceCalc = annoyanceCalc;
    }

    @Override
    public BigDecimal withdraw(LocalDate date, String currencyFrom, BigDecimal amountOfCash) throws InvalidCurrencyNameException, NoConnectionException, DateTimeParseException {

        BigDecimal actualRate;

        BigDecimal rate;

        BigDecimal ownedBtc;

        BigDecimal actualValueInCash;

        BigDecimal percentageProfit;

        BigDecimal profitInCurrency;

        String annoyanceLevel;

        AbstractBtcExchangeLog log;

        actualRate = getRateFromUrl.getActualBtcRateFromUrl(currencyFrom);
        rate = getRateFromUrl.getHistoricalBtcRateFromUrl(currencyFrom, date);
        ownedBtc = amountOfCash.divide(rate, 10, RoundingMode.HALF_UP);
        actualValueInCash = ownedBtc.multiply(actualRate);
        percentageProfit = ((actualRate.subtract(rate)).divide(rate, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)).setScale(1, RoundingMode.HALF_UP);
        profitInCurrency = actualValueInCash.subtract(amountOfCash).setScale(2, RoundingMode.HALF_UP);
        annoyanceLevel = annoyanceCalc.calculateAnnoyanceLevel(profitInCurrency, btcExchangeLog.getEntitiesAmount());
        log = new BtcExchangeLog(date, amountOfCash, currencyFrom, ownedBtc, rate, profitInCurrency, percentageProfit, actualRate, annoyanceLevel);

        btcExchangeLog.save(log);
        return actualValueInCash;
    }
}