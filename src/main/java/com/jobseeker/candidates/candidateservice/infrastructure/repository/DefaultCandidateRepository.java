package com.jobseeker.candidates.candidateservice.infrastructure.repository;

import com.jobseeker.candidates.candidateservice.domain.Candidate;
import com.jobseeker.candidates.candidateservice.domain.CandidateRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Repository;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DefaultCandidateRepository implements CandidateRepository {

    private final com.mongodb.client.MongoClient mongoClient;

    private final MongoCollection<Candidate> mongoCollection;

    public DefaultCandidateRepository(
            DatabaseConfiguration configuration,
            com.mongodb.client.MongoClient mongoClient) {
        this.mongoClient = mongoClient;

        final String mongoDbName = configuration.getMongoDbName();
        final String mongoCollectionName = configuration.getMongoCollectionName();


        final CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        final MongoDatabase mongoDatabase = this.mongoClient.getDatabase(mongoDbName).withCodecRegistry(pojoCodecRegistry);
        mongoCollection = mongoDatabase.getCollection(mongoCollectionName, Candidate.class);
    }

    @Override
    public void save(Candidate candidate) {
        mongoCollection.insertOne(candidate);
    }
}
