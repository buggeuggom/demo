package com.ajou.demo.controller.response;

import lombok.Builder;
import lombok.Getter;


@Getter
public class ErrorResponse {
    private final String resultCode;
    private final String message;


    @Builder
    public ErrorResponse(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
