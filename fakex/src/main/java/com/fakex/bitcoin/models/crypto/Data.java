package com.fakex.bitcoin.models.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data public class Data {

    private Asset data;

    public Data() {
    }
}
