package com.jobseeker.candidates.candidateservice.application;

import com.jobseeker.candidates.candidateservice.application.constants.Constants;
import com.jobseeker.candidates.candidateservice.application.validation.ValidationResult;
import com.jobseeker.candidates.candidateservice.application.validation.ValidationService;
import com.jobseeker.candidates.candidateservice.interfaces.ApiError;
import com.jobseeker.candidates.candidateservice.interfaces.request.CandidateRequest;
import com.jobseeker.candidates.candidateservice.interfaces.response.CandidateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(Constants.CANDIDATE_CONTROLLER_MAPPING)
@Slf4j
public class CandidateController {

    private final ValidationService<CandidateRequest> candidateRequestValidationService;
    private final CandidateService candidateService;

    public CandidateController(ValidationService<CandidateRequest> candidateRequestValidationService, CandidateService candidateService) {
        this.candidateRequestValidationService = candidateRequestValidationService;
        this.candidateService = candidateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidate(@PathVariable String id){
        return null;
    }


    @PostMapping
    public ResponseEntity addCandidate(@RequestBody CandidateRequest request){
        final ValidationResult validationResult = candidateRequestValidationService.validate(request);

        if (!validationResult.getIsValid()){
            log.warn(validationResult.getMessage());
            return new ResponseEntity<>(ApiError.create(HttpStatus.BAD_REQUEST.value(), validationResult.getMessage(), validationResult.getErrorCode().code()), HttpStatus.BAD_REQUEST);
        }

        candidateService.addCandidateInformation(request);

        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        log.warn("Unhandled exception occurred!", ex);
        return new ResponseEntity<>(ApiError.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), "CS1000"), HttpStatus.BAD_REQUEST);
    }
}
