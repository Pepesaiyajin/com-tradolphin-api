package com.fakex.bitcoin.models.users;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "transactions")
@Data public class Transaction {

    private Date timestamp = new Date();
    private String symbol;
    private int quantity;
    private double pricePerUnit;

    @Id
    private int id;
    private TransactionType transactionType;

    public double getFullPrice(){
        return quantity*pricePerUnit;
    }

    public Transaction() {
    }
}
