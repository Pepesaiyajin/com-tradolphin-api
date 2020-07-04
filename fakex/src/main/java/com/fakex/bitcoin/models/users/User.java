package com.fakex.bitcoin.models.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Document(collection = "users")
@Data public class User {

    private String firstname;
    private String lastname;
    @Id
    private String email;
    private String password;

    private Wallet wallet;

    private Binary image;


    public User(String firstname, String lastname, String email, String password, Wallet wallet) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }
}
