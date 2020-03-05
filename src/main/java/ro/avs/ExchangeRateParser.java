package ro.avs;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public abstract class ExchangeRateParser<T> {

    private final Class<T> type;

    protected ExchangeRateParser(Class<T> type) {
        this.type = type;
    }

    protected T parseExchangeRates(String values) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(values, type);
    }

    public abstract T getExchangeRateData();
}
