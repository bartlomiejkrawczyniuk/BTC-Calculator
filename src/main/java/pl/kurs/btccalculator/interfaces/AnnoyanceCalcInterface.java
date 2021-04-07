package pl.kurs.btccalculator.interfaces;

import java.math.BigDecimal;

public interface AnnoyanceCalcInterface {

    public String calculateAnnoyanceLevel(BigDecimal profitInCurrency, int numberOfChecks);
}
