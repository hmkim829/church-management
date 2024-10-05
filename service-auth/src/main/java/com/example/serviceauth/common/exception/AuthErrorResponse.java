package com.example.serviceauth.common.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthErrorResponse {

    private int code;
    private String message;

    @Builder
    protected AuthErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
