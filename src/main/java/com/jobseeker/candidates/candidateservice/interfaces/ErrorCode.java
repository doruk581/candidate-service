package com.jobseeker.candidates.candidateservice.interfaces;

public enum ErrorCode {
    NAMEISINVALID("CS1001"),
    SURNAMEISINVALID("CS1002"),
    EMAILISINVALID("CS1003"),
    AGEISINVALID("CS1004"),
    PHONEISINVALID("CS1005");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }
}