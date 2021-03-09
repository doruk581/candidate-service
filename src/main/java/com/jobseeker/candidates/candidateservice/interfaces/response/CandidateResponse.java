package com.jobseeker.candidates.candidateservice.interfaces.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CandidateResponse {
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String phoneNumber;
    private String IdentityNumber;
}
