package com.example.serviceauth.controller.request;

import lombok.Getter;

@Getter
public class AuthRegisterRequest {
    private String loginId;
    private String email;
    private String password;
}
