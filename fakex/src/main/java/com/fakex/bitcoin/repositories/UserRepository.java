package com.fakex.bitcoin.repositories;

import com.fakex.bitcoin.models.crypto.Asset;
import com.fakex.bitcoin.models.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

}
