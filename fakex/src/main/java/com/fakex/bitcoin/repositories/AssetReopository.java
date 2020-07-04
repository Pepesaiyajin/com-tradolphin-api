package com.fakex.bitcoin.repositories;

import com.fakex.bitcoin.models.crypto.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AssetReopository extends MongoRepository<Asset, String> {
    Optional<Asset> findByName(String name);
}
