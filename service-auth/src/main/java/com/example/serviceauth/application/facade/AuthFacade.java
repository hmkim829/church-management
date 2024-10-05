package com.example.serviceauth.application.facade;

import com.example.serviceauth.application.service.UserService;
import com.example.serviceauth.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final UserService userService;

    // 회원가입 처리
    public User register(String loginId, String email, String password) {
        return userService.register(loginId, email, password);
    }
}
