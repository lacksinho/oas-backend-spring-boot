package com.ladam.oas.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorDetails {
    private final int statusCode;
    private final String message;
    private final Map<String, String> errors;

    public ErrorDetails(int statusCode, String message) {
        this(statusCode, message, null);
    }


    public ErrorDetails(int statusCode, String message, Map<String, String> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
    }

}

