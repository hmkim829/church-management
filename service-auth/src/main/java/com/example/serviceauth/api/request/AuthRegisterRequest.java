package com.example.serviceauth.api.request;

import lombok.Getter;

@Getter
public class AuthRegisterRequest {
    private String loginId;
    private String email;
    private String password;
}
