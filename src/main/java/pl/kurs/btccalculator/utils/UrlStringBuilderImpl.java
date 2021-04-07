package pl.kurs.btccalculator.utils;

import org.springframework.stereotype.Component;
import pl.kurs.btccalculator.interfaces.UrlStringBuilderInterface;

import java.time.LocalDate;

@Component
public class UrlStringBuilderImpl implements UrlStringBuilderInterface {

    @Override
    public String buildHistoricalUrl(String baseHttp, String currencyParameter, LocalDate date) {
        return new StringBuilder(baseHttp)
                .append("?start=")
                .append(date)
                .append("&end=")
                .append(date)
                .append("&currency=")
                .append(currencyParameter.toUpperCase())
                .toString();
    }

    @Override
    public String buildActualUrl(String baseHttp, String currencyParameter) {
        return new StringBuilder(baseHttp)
                .append(currencyParameter.toUpperCase())
                .append(".json")
                .toString();
    }
}
//        https://api.coindesk.com/v1/bpi/historical/close.json?start=2021-02-10&end=2021-02-10&currency=PLN
//        https://api.coindesk.com/v1/bpi/currentprice/PLN.json