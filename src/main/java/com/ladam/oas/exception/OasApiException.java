package com.ladam.oas.exception;

import org.springframework.http.HttpStatus;

public class OasApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	private final HttpStatus status;

    public OasApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
