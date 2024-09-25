package com.example.serviceauth.common.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthErrorResponse {

    private int status;
    private String message;

    @Builder
    protected AuthErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
