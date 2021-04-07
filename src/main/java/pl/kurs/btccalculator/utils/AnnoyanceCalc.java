package pl.kurs.btccalculator.utils;

import org.springframework.stereotype.Component;
import pl.kurs.btccalculator.interfaces.AnnoyanceCalcInterface;

import java.math.BigDecimal;

@Component
public class AnnoyanceCalc implements AnnoyanceCalcInterface {

    @Override
    public String calculateAnnoyanceLevel(BigDecimal profitInCurrency, int numberOfChecks){
        double profit = profitInCurrency.doubleValue();
        String annoyanceLevel = "Spokój";

        if (profit > 1000 && profit <= 5000)
            annoyanceLevel = "Zażenowanie";
        if (profit > 5000 && profit <= 15000)
            annoyanceLevel = "Irytacja";
        if (profit > 15000 && profit <= 50000)
            annoyanceLevel = "Złość";
        if (profit > 50000 && profit <= 100000)
            annoyanceLevel = "Zdenerwowanie";
        if (profit > 100000 && profit <= 300000)
            annoyanceLevel = "Wściekłość";
        if (profit > 300000 && profit <= 1000000)
            annoyanceLevel = "Atak szału";
        if (profit > 1000000)
            annoyanceLevel = "Wkurwienie";

        if (numberOfChecks <= 5)
            annoyanceLevel += " level 10";
        if (numberOfChecks <= 10 && numberOfChecks > 5)
            annoyanceLevel += " level 100";
        if (numberOfChecks <= 20 && numberOfChecks > 15)
            annoyanceLevel += " level 1000";
        if (numberOfChecks > 20)
            annoyanceLevel += " level 10000";

        return annoyanceLevel;
    }
}
