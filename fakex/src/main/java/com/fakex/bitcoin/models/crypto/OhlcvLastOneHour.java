package com.fakex.bitcoin.models.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data public class OhlcvLastOneHour {

    float open = 0;
    float high = 0;
    float low = 0;
    float close = 0;
    float volume = 0;

    public OhlcvLastOneHour(float open, float high, float low, float close, float volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public OhlcvLastOneHour() {
    }

}
