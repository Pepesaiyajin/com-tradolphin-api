package com.fakex.bitcoin.models.crypto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data public class Market {


    int price_usd = 0;
    int price_btc = 0;
    long volume_last_24_hours = 0;
    long real_volume_last_24_hours = 0;
    int percent_change_usd_last_24_hours = 0;
    int percent_change_btc_last_24_hours = 0;


    private OhlcvLastOneHour ohlcv_last_1_hour;
    private OhlcvLast24Hour ohlcv_last_24_hour;

    public Market(int price_usd, int price_btc, long volume_last_24_hours, long real_volume_last_24_hours, int percent_change_usd_last_24_hours, int percent_change_btc_last_24_hours, OhlcvLastOneHour ohlcv_last_1_hour, OhlcvLast24Hour ohlcv_last_24_hour) {
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.volume_last_24_hours = volume_last_24_hours;
        this.real_volume_last_24_hours = real_volume_last_24_hours;
        this.percent_change_usd_last_24_hours = percent_change_usd_last_24_hours;
        this.percent_change_btc_last_24_hours = percent_change_btc_last_24_hours;
        this.ohlcv_last_1_hour = ohlcv_last_1_hour;
        this.ohlcv_last_24_hour = ohlcv_last_24_hour;
    }

    public Market() {
    }

}
