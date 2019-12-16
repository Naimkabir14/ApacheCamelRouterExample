package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface payloadRepo extends MongoRepository<payloadReception, String> {
          payloadReception findBypayloadName(String name);
}

