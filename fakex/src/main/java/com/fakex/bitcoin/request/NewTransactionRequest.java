package com.fakex.bitcoin.request;

import com.fakex.bitcoin.models.users.Transaction;
import lombok.Data;

@Data public class NewTransactionRequest {

    private String userEmail;
    private Transaction transaction;

}
