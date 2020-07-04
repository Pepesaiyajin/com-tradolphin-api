package com.fakex.bitcoin.models.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data public class OhlcvLast24Hour {

    float open = 0;
    float high = 0;
    float low = 0;
    float close = 0;
    float volume = 0;

    public OhlcvLast24Hour(float open, float high, float low, float close, float volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public OhlcvLast24Hour() {
    }

}
