package pl.kurs.btccalculator.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import pl.kurs.btccalculator.exceptions.InvalidCurrencyNameException;
import pl.kurs.btccalculator.exceptions.NoConnectionException;
import pl.kurs.btccalculator.interfaces.GetRateFromUrlInterface;
import pl.kurs.btccalculator.interfaces.UrlStringBuilderInterface;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDate;

@Service
@PropertySource("classpath:application.properties")
public class GetRateFromUrlImpl implements GetRateFromUrlInterface {

    @Autowired
    private Environment env;

    private ObjectMapper mapper;
    private UrlStringBuilderInterface urlStringBuilder;

    @Autowired
    public GetRateFromUrlImpl(ObjectMapper mapper, UrlStringBuilderInterface urlStringBuilder) {
        this.mapper = mapper;
        this.urlStringBuilder = urlStringBuilder;
    }

    @Override
    public BigDecimal getHistoricalBtcRateFromUrl(String currencyParameter, LocalDate date) throws InvalidCurrencyNameException, NoConnectionException {
        String preparedUrl = urlStringBuilder.buildHistoricalUrl(env.getProperty("bitcoinHistoricalRateApiPage"),
                    currencyParameter, date);

        JsonNode mainTree = null;
        try {
            mainTree = mapper.readTree(new URL(preparedUrl));
        } catch (UnknownHostException | MalformedURLException e) {
            throw new NoConnectionException("Problemy z siecią, spróbuj ponownie później");
        } catch (IOException e) {
            throw new InvalidCurrencyNameException("Błędna nazwa waluty");
        }
        JsonNode rateJsonNode = mainTree.get("bpi");
        JsonNode specificRateNode = rateJsonNode.get(date.toString());
        if (specificRateNode == null)
            throw new InvalidCurrencyNameException("Błędna nazwa waluty");

        return new BigDecimal(specificRateNode.asText());
    }

    @Override
    public BigDecimal getActualBtcRateFromUrl(String currencyParameter) throws NoConnectionException, InvalidCurrencyNameException {
        String preparedUrl = urlStringBuilder.buildActualUrl(env.getProperty("bitcoinActualRateApiPage"),
                currencyParameter);

        JsonNode mainTree = null;
        try {
            mainTree = mapper.readTree(new URL(preparedUrl));
        } catch (UnknownHostException | MalformedURLException e) {
            throw new NoConnectionException("Problemy z siecią, spróbuj ponownie później");
        } catch (IOException e) {
            throw new InvalidCurrencyNameException("Błędna nazwa waluty");
        }
        JsonNode rateJsonNode = mainTree.get("bpi");
        JsonNode currencyRateNode = rateJsonNode.get(currencyParameter.toUpperCase());
        JsonNode result = currencyRateNode.get("rate_float");
        if (result == null)
            throw new InvalidCurrencyNameException("Błędna nazwa waluty");

        return new BigDecimal(result.asText());
    }
}
