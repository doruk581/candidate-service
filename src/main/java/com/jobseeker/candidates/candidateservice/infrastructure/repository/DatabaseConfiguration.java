package com.jobseeker.candidates.candidateservice.infrastructure.repository;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("candidate-configuration")
@Getter
@Setter
public class DatabaseConfiguration {

    @Value("mongo-db-connection-string")
    private String mongoDbConnectionString;
    @Value("mongo-db-name")
    private String mongoDbName;
    @Value("mongo-collection-name")
    private String mongoCollectionName;
}