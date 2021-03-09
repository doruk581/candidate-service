package com.jobseeker.candidates.candidateservice.domain;

import com.jobseeker.candidates.candidateservice.application.CandidateService;
import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;
import com.jobseeker.candidates.candidateservice.interfaces.response.CandidateResponse;

import java.util.List;

public class DefaultCandidateService implements CandidateService {

    private final CandidateRepository candidateRepository;

    private final MernisService mernisService;

    private final CandidateFactory candidateFactory;

    public DefaultCandidateService(CandidateRepository candidateRepository, MernisService mernisService, CandidateFactory candidateFactory) {
        this.candidateRepository = candidateRepository;
        this.mernisService = mernisService;
        this.candidateFactory = candidateFactory;
    }

    @Override
    public List<CandidateResponse> getCandidate() {
        return null;
    }

    @Override
    public void addCandidateInformation(CandidateRequest candidateRequest) {
        final Candidate candidate = candidateFactory.createCandidate(candidateRequest);

        candidateRepository.save(candidate);
    }
}
