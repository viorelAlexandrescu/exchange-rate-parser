package ro.avs.bnr.parser;

import ro.avs.ExchangeRateParser;
import ro.avs.bnr.model.Cube;
import ro.avs.bnr.model.DataSet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BnrExchangeRateParser extends ExchangeRateParser<DataSet> {

    public BnrExchangeRateParser() {
        super(DataSet.class);
    }

    public Cube getExchangeRatesCube() {
        DataSet dataSet = getExchangeRateData();
        return dataSet.getBody().getCube();
    }

    @Override
    public DataSet getExchangeRateData() {
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://ww.bnr.ro/nbrfxrates.xml"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return parseExchangeRates(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
