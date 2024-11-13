package com.ajou.demo.exception;


import com.ajou.demo.controller.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.ajou.demo.exception.ErrorCode.DATABASE_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(GlobalApplicationException.class)
    public ResponseEntity<ErrorResponse> novelApplicationExceptionHandler(GlobalApplicationException e) {
        log.error("GlobalApplicationException occurs {}", e.toString());
        var body = ErrorResponse.builder()
                .resultCode(e.getErrorCode().name())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e) {
        log.error("Error occurs {}", e.toString());

        return ResponseEntity.status(DATABASE_ERROR.getStatus())
                .body(ErrorResponse.builder()
                        .resultCode(DATABASE_ERROR.name())
                        .message(DATABASE_ERROR.getMessage()));
    }
}
