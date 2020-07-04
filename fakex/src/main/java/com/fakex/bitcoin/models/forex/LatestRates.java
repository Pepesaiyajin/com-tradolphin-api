package com.fakex.bitcoin.models.forex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "FXRates")
@Data
public class LatestRates {

    private Map<String, Double> rates;

    @Id
    private boolean True;

    @Field
    private String timestamp;

    @Field
    private String base;

    public LatestRates(boolean aTrue, String timestamp, String base, String date) {
        True = aTrue;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
    }
    public LatestRates(){}

    @Field
    private String date;
}
