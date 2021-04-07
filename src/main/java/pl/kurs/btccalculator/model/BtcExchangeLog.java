package pl.kurs.btccalculator.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "btcexchangelog", schema = "bitcoin_sell_log")
public class BtcExchangeLog extends AbstractBtcExchangeLog {
    private static final long serialVersionUID = 1L;

    public BtcExchangeLog(LocalDate boughtDate, BigDecimal amountOfCash, String currency, BigDecimal amountOfBoughtBtc, BigDecimal boughtBtcRate, BigDecimal profitInCurrency, BigDecimal percentageProfit, BigDecimal saleBtcRate, String annoyanceLevel) {
        super(boughtDate, amountOfCash, currency, amountOfBoughtBtc, boughtBtcRate, profitInCurrency, percentageProfit, saleBtcRate, annoyanceLevel);
    }

    public BtcExchangeLog() {
    }
}