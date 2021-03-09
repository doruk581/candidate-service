package com.jobseeker.candidates.candidateservice.domain;

import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;

public class DefaultCandidateFactory implements CandidateFactory {

    @Override
    public Candidate createCandidate(CandidateRequest request) {
        return Candidate
                .builder()
                .age(request.getAge())
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}
