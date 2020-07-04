package com.fakex.bitcoin.models.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "asset")
@Data public class Asset {

    @Id
    private String id;
    @Field
    private String symbol;
    @Field
    private String name;

    private Date lastupdate;

    private Market market_data;
    private MarketCap marketcap;

    private List<List<Double>> values;

    public Asset(String id, String symbol, String name) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    public Asset() {
    }
}
