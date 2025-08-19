package com.ladam.oas.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ladam.oas.dto.ResponseDTO;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseDTO<T>> build(HttpStatus status, T data) {
        return ResponseEntity.status(status).body(new ResponseDTO<>(status.value(), data));
    }
}
