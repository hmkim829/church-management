package com.example.serviceauth.facade;

import com.example.serviceauth.user.entity.User;
import com.example.serviceauth.user.service.UserService;
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
