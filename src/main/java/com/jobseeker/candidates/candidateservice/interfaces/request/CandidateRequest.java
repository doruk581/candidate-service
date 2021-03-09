package com.jobseeker.candidates.candidateservice.interfaces.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateRequest {

    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String phoneNumber;
    private String IdentityNumber;
}
