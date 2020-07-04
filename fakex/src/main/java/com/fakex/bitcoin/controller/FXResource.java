package com.fakex.bitcoin.controller;

import com.fakex.bitcoin.models.forex.DataCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/forex")

public class FXResource {
        @Value("ded3df8916f85ebbc2a603ab4377dd64")
        private String FixerAPIKey;

        @Autowired
        private MongoTemplate mongoTemplate;

        @Autowired
        private RestTemplate restTemplate;


        @GetMapping("/rates")
        public DataCurrency getAssetInfo(){
                String url = "http://data.fixer.io/api/latest?access_key=" + FixerAPIKey;
                return restTemplate.getForObject(url, DataCurrency.class);
        }
}
