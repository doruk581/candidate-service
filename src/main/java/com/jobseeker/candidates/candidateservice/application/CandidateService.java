package com.jobseeker.candidates.candidateservice.application;

import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;
import com.jobseeker.candidates.candidateservice.interfaces.response.CandidateResponse;

import java.util.List;

public interface CandidateService {

    List<CandidateResponse> getCandidate();

    void addCandidateInformation(final CandidateRequest candidateRequest);
}
