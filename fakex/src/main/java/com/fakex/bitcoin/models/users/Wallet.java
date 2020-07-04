package com.fakex.bitcoin.models.users;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data public class Wallet {

    List<Transaction> transactions = new LinkedList();
    private double balance = 10000;
    private String currency = "$";

    public void addTransaction(Transaction transaction) throws Exception{
        //TODO check if the current balance is enough
        if(balance >= transaction.getFullPrice()) {
            balance -= transaction.getFullPrice();
            transactions.add(transaction);
        }
        else {
            throw new Exception();
        }
    }

    public void sellTransaction(int id){
        transactions.removeIf(i -> i.getId() == id);
    }

    public Wallet() {
    }
}
