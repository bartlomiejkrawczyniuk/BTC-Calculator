package pl.kurs.btccalculator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

@MappedSuperclass
public abstract class AbstractBtcExchangeLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "boughtDate")
    private LocalDate boughtDate;

    @Column(name = "amountOfCash")
    private BigDecimal amountOfCash;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amountOfBoughtBtc")
    private BigDecimal amountOfBoughtBtc;

    @Column(name = "boughtBtcRate")
    private BigDecimal boughtBtcRate;

    @Column(name = "saleDate")
    private LocalDate saleDate;

    @Column(name = "profitInCurrency")
    private BigDecimal profitInCurrency;

    @Column(name = "percentageProfit")
    private BigDecimal percentageProfit;

    @Column(name = "saleBtcRate")
    private BigDecimal saleBtcRate;

    @Column(name = "annoyanceLevel")
    private String annoyanceLevel;

    public AbstractBtcExchangeLog(LocalDate boughtDate, BigDecimal amountOfCash, String currency, BigDecimal amountOfBoughtBtc, BigDecimal boughtBtcRate, BigDecimal profitInCurrency, BigDecimal percentageProfit, BigDecimal saleBtcRate, String annoyanceLevel) {
        this.timestamp = Timestamp.from(Instant.now().atOffset(ZoneOffset.UTC).toInstant());
        this.boughtDate = boughtDate;
        this.amountOfCash = amountOfCash;
        this.currency = currency.toUpperCase();
        this.amountOfBoughtBtc = amountOfBoughtBtc;
        this.boughtBtcRate = boughtBtcRate;
        this.saleDate = LocalDate.now();
        this.profitInCurrency = profitInCurrency;
        this.percentageProfit = percentageProfit;
        this.saleBtcRate = saleBtcRate;
        this.annoyanceLevel = annoyanceLevel;
    }

    public AbstractBtcExchangeLog() {
    }
}
