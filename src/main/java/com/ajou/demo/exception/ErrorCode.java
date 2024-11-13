package com.ajou.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //404
    USER_NOT_FOUND(NOT_FOUND, "User not founded"),
    EQUIPMENT_NOT_FOUND(NOT_FOUND, "Equipment not founded"),

    DATABASE_ERROR(INTERNAL_SERVER_ERROR, "Database error occurs"),
    ;

    private final HttpStatus status;
    private final String message;
}
