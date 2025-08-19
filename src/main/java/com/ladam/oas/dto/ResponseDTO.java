package com.ladam.oas.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"statusCode", "data"})
public class ResponseDTO<T> {
    private int statusCode;
    private T data;


    public ResponseDTO(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}