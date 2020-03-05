package ro.avs.oer.model;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ExchangeRateData {

    private long timestamp;
    private String base;
    private Map<String, Double> rates = new HashMap<>();
}
