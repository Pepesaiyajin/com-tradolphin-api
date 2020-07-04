package com.fakex.bitcoin.request;

import lombok.Data;

@Data public class DeleteTransactionRequest {

    private String userEmail;
    private int transactionId;
}
