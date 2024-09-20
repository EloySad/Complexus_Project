package com.riwi.complexus.api.dto.errors;

import java.util.List;

public class ErrorsResp extends BaseErrorResponse{
    
    public ErrorsResp() {
        super();
    }

    public ErrorsResp(int code, String status, List<String> errors) {
        super(code, status, errors);
    }

    public static ErrorsRespBuilder builder() {
        return new ErrorsRespBuilder();
    }

    public static class ErrorsRespBuilder {
        private int code;
        private String status;
        private List<String> errors;

        public ErrorsRespBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ErrorsRespBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ErrorsRespBuilder errors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public ErrorsResp build() {
            return new ErrorsResp(code, status, errors);
        }
    }
}
