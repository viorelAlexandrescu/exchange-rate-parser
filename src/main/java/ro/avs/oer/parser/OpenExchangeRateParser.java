package ro.avs.oer.parser;

import org.apache.http.client.utils.URIBuilder;
import ro.avs.ExchangeRateParser;
import ro.avs.oer.model.ExchangeRateData;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Currency;

public class OpenExchangeRateParser extends ExchangeRateParser<ExchangeRateData> {

    private final String appDevKey;
    private String currency;

    public OpenExchangeRateParser(String appDevKey, String currency) {
        super(ExchangeRateData.class);
        this.appDevKey = appDevKey;
        this.currency = currency;
    }

    public OpenExchangeRateParser(String appDevKey) {
        this(appDevKey, Currency.getInstance("RON").getCurrencyCode());
    }

    @Override
    public ExchangeRateData getExchangeRateData() {
        try {
            URIBuilder uriBuilder = new URIBuilder("https://openexchangerates.org/api/latest.json")
                    .addParameter("app_id", appDevKey)
                    .addParameter("base", currency);
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uriBuilder.build())
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return parseExchangeRates(response.body());
        } catch (Exception e) {
            return null;
        }
    }


}
