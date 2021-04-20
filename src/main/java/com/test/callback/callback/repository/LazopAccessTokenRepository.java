package com.test.callback.callback.repository;

import com.test.callback.callback.model.LazopAccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LazopAccessTokenRepository extends MongoRepository<LazopAccessToken, String> {
    public LazopAccessToken findByStorer(String storer);
}
