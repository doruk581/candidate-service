package com.jobseeker.candidates.candidateservice.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String phoneNumber;
    private BigDecimal candidateCreditScore;



    public String prepareFullName(){
        return this.name + " " + this.surname;
    }
}
