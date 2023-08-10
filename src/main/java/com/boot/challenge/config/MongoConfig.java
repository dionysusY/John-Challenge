package com.boot.challenge.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @ccc
 * @date 2023/8/9 - 23:53
 */
@Configuration
public class MongoConfig {

    private final static String REMOTE_DB = "mongodb://81.68.219.146:27017";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(REMOTE_DB);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "challenge");
    }
}
