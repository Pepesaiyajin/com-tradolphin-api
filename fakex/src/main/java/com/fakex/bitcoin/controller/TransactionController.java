package com.fakex.bitcoin.controller;

import com.fakex.bitcoin.models.users.TransactionType;
import com.fakex.bitcoin.models.users.User;
import com.fakex.bitcoin.repositories.AssetReopository;
import com.fakex.bitcoin.repositories.UserRepository;
import com.fakex.bitcoin.request.DeleteTransactionRequest;
import com.fakex.bitcoin.request.NewTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody NewTransactionRequest request) {
        //TODO security check if request is valid
        try {
            User user = userRepository.findByEmail(request.getUserEmail()).get();
            request.getTransaction().setTransactionType(TransactionType.BUY);
            user.getWallet().addTransaction(request.getTransaction());
            mongoTemplate.save(user);

        } catch (Exception e) {
            return ResponseEntity.status(550).body("not enough money on your account");
        }
        return ResponseEntity.ok("Transaction added");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTransaction(@RequestBody DeleteTransactionRequest request) {

        User user = userRepository.findByEmail(request.getUserEmail()).get();
        user.getWallet().sellTransaction(request.getTransactionId());
        mongoTemplate.save(user);
        return ResponseEntity.ok("Transaction deleted");
    }


}
