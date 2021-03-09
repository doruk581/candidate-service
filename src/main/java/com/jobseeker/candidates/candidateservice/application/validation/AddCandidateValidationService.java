package com.jobseeker.candidates.candidateservice.application.validation;

import com.jobseeker.candidates.candidateservice.interfaces.ErrorCode;
import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;

public class AddCandidateValidationService implements ValidationService<CandidateRequest> {

    @Override
    public ValidationResult validate(CandidateRequest request) {

        if (request.getName() == null || request.getName().isEmpty())
            return ValidationResult.error("Name cannot be null or empty!", ErrorCode.NAMEISINVALID);

        if (request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty())
            return ValidationResult.error("Phone number cannot be empty!", ErrorCode.PHONEISINVALID);

        return ValidationResult.success();
    }
}
