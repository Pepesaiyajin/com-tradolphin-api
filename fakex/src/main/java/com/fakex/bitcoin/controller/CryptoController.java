package com.fakex.bitcoin.controller;

import com.fakex.bitcoin.models.crypto.Asset;
import com.fakex.bitcoin.models.crypto.Data;
import com.fakex.bitcoin.models.crypto.Market;
import com.fakex.bitcoin.models.crypto.MarketCap;
import com.fakex.bitcoin.repositories.AssetReopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class CryptoController {

    @Value("750d43a8-dcc2-4a94-8170-afab307c16ce")
    private String apiKey;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AssetReopository assetReopository;

    @GetMapping(value = "/{id}/db")
    public Asset getAssetdb(@PathVariable String id){
        try {
            return assetReopository.findByName("bitcoin").get();
        }
        catch (NullPointerException e){
            System.err.println("Asset not found in db");
            return null;
        }
    }

    @GetMapping("/{id}")
    public Asset getAssetInfo(@PathVariable String id){
        try {
            Data asset = restTemplate.getForObject("https://data.messari.io/api/v1/assets/"+ id +"/metrics", Data.class);
            return asset.getData();
        }
        catch (HttpClientErrorException e){
            System.err.println("Asset not found");
            return null;
        }
    }

    @GetMapping("/{id}/market")
    public Market getMarketInfo(@PathVariable String id){
        try {
            Data marketInfo = restTemplate.getForObject("https://data.messari.io/api/v1/assets/"+ id +"/metrics", Data.class);
            return marketInfo.getData().getMarket_data();
        }
        catch (HttpClientErrorException e){
            System.err.println("Asset not found");
            return null;
        }
    }

    @GetMapping("/{id}/marketcap")
    public MarketCap getMarketCapInfo(@PathVariable String id){
        try {
            Data marketCap = restTemplate.getForObject("https://data.messari.io/api/v1/assets/"+ id +"/metrics", Data.class);
            return marketCap.getData().getMarketcap();
        }
        catch (HttpClientErrorException e){
            System.err.println("Asset not found");
            return null;
        }

    }
    @GetMapping("/{id}/history")
    public List getMarketHistory(@PathVariable String id){
        try {
            Data marketHisotry = restTemplate.getForObject("https://data.messari.io/api/v1/assets/"+ id +"/metrics/price/time-series", Data.class);
            return marketHisotry.getData().getValues();
        }
        catch (HttpClientErrorException e){
            System.err.println("Asset not found");
            return null;
        }

    }
    @PutMapping("/{id}/refresh")
    public void refreshAsset(@PathVariable String id){
        try {
            Data refreshasset = restTemplate.getForObject("https://data.messari.io/api/v1/assets/"+ id +"/metrics/price/time-series", Data.class);
            mongoTemplate.save(refreshasset.getData());
        }
        catch (HttpClientErrorException e){
            System.err.println("Asset not found");
        }
    }
}
