package com.jobseeker.candidates.candidateservice;

import com.jobseeker.candidates.candidateservice.application.CandidateService;
import com.jobseeker.candidates.candidateservice.application.validation.AddCandidateValidationService;
import com.jobseeker.candidates.candidateservice.application.validation.ValidationService;
import com.jobseeker.candidates.candidateservice.domain.*;
import com.jobseeker.candidates.candidateservice.infrastructure.mernisservicegateway.DefaultMernisService;
import com.jobseeker.candidates.candidateservice.infrastructure.repository.DatabaseConfiguration;
import com.jobseeker.candidates.candidateservice.infrastructure.repository.DefaultCandidateRepository;
import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Main {

	@Bean
	public AddCandidateValidationService candidateRequestValidationService(){
		return new AddCandidateValidationService();
	}

	@Bean
	public MernisService getMernisService(){
		return new DefaultMernisService();
	}

	@Bean
	public MongoClient getMongoClient(DatabaseConfiguration configuration) {
		final String mongoConnectionString = configuration.getMongoDbConnectionString();
		return MongoClients.create(mongoConnectionString);
	}

	@Bean
	CandidateRepository getCandidateRepository(DatabaseConfiguration configuration, MongoClient mongoClient) {
		return new DefaultCandidateRepository(configuration, mongoClient);
	}

	@Bean
	public CandidateService getCandidateService(CandidateRepository candidateRepository, MernisService mernisService, CandidateFactory candidateFactory){
		return new DefaultCandidateService(candidateRepository,mernisService,candidateFactory);
	}

	@Bean
	public CandidateFactory getCandidateFactory(){
		return new DefaultCandidateFactory();
	}


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
