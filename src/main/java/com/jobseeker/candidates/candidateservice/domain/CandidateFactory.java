package com.jobseeker.candidates.candidateservice.domain;

import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;

public interface CandidateFactory {

     Candidate createCandidate(CandidateRequest request);

}
