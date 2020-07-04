package com.fakex.bitcoin.models.forex;


import java.util.Map;

@lombok.Data public class DataCurrency {

    private Map<String, Double> rates;

    public DataCurrency(){
    }

    public double getRate(String currency){
        return (rates.containsKey(currency) ? rates.get(currency) : -1);
    }
}
