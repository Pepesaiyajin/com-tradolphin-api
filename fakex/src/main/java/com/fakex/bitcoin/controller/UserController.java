package com.fakex.bitcoin.controller;

import com.fakex.bitcoin.models.users.User;
import com.fakex.bitcoin.models.users.Wallet;
import com.fakex.bitcoin.repositories.AssetReopository;
import com.fakex.bitcoin.repositories.UserRepository;
import com.fakex.bitcoin.request.UserInfoRequest;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/balance")
    public Wallet getUserBalance(@RequestBody UserInfoRequest userInfoRequest){
        //ToDo if user / email exist (if present)
        User user = userRepository.findByEmail(userInfoRequest.getEmail()).get();
        System.out.println("ok");
        return user.getWallet();
    }

    @PostMapping("/claim")
    public ResponseEntity<?> getFreeMoney(@RequestBody UserInfoRequest userInfoRequest, @RequestParam double value){
        //ToDo if user / email exist (if present)
        User user = userRepository.findByEmail(userInfoRequest.getEmail()).get();
        user.getWallet().setBalance(user.getWallet().getBalance() + value);
        mongoTemplate.save(user);
        return ResponseEntity.ok("200");
    }

    @PostMapping("/photo")
    public ResponseEntity<?> setImage(@RequestBody UserInfoRequest userInfoRequest, @RequestParam MultipartFile image) throws IOException {
        User user = userRepository.findByEmail(userInfoRequest.getEmail()).get();
        user.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        mongoTemplate.save(user);
        return ResponseEntity.ok("200");
    }


}
