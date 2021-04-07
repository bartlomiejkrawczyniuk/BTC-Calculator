package pl.kurs.btccalculator.interfaces;

import java.time.LocalDate;

public interface UrlStringBuilderInterface {

    String buildHistoricalUrl(String baseHttp, String currencyParameter, LocalDate date);

    String buildActualUrl(String baseHttp, String currencyParameter);
}
