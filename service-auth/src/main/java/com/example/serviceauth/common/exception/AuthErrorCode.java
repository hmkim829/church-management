package com.example.serviceauth.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode {

    SUCCESS(100000, "TEST"),

    // auth
    LOGIN_ID_ALREADY_EXISTS(200000, "로그인 ID가 이미 존재합니다."),
    EMAIL_ALREADY_EXISTS(200001, "이메일이 이미 존재합니다."),

    ;

    private final int code;
    private final String message;
}
