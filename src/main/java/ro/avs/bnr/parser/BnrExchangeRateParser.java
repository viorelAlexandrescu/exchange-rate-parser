package ro.avs.bnr.parser;

import ro.avs.bnr.ExchangeRateParser;
import ro.avs.bnr.model.Cube;
import ro.avs.bnr.model.DataSet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BnrExchangeRateParser extends ExchangeRateParser<DataSet> {

    public BnrExchangeRateParser() {
        super(DataSet.class);
    }

    public Cube getExchangeRatesCube() throws IOException {
        URL url = new URL("https://www.bnr.ro/nbrfxrates.xml");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        DataSet dataSet = parseExchangeRates(con.getResponseMessage());
        return dataSet.getBody().getCube();
    }
}
