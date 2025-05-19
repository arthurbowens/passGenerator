package br.com.passGenerator.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final int statusCode;

    public AppException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
} 