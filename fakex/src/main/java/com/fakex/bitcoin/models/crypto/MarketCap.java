package com.fakex.bitcoin.models.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data public class MarketCap {

    float marketcap_dominance_percent = 0;
    float current_marketcap_usd = 0;
    double liquid_marketcap_usd = 0;
    double realized_marketcap_usd = 0;


    public MarketCap() {
    }

    public MarketCap(float marketcap_dominance_percent, float current_marketcap_usd, double liquid_marketcap_usd, double realized_marketcap_usd) {
        this.marketcap_dominance_percent = marketcap_dominance_percent;
        this.current_marketcap_usd = current_marketcap_usd;
        this.liquid_marketcap_usd = liquid_marketcap_usd;
        this.realized_marketcap_usd = realized_marketcap_usd;
    }
}
