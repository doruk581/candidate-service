package com.jobseeker.candidates.candidateservice.application.validation;


public interface ValidationService<T> {
    ValidationResult validate(T request);
}