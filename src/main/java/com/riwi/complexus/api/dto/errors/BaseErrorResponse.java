package com.riwi.complexus.api.dto.errors;

import java.util.List;

public class BaseErrorResponse {
    
    private int code;
    private String status;
    private List<String> errors;

    public BaseErrorResponse() {
    }

    public BaseErrorResponse(int code, String status, List<String> errors) {
        this.code = code;
        this.status = status;
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


}
