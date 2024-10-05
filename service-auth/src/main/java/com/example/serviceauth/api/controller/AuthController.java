package com.example.serviceauth.api.controller;

import com.example.serviceauth.api.request.AuthRegisterRequest;
import com.example.serviceauth.application.facade.AuthFacade;
import com.example.serviceauth.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRegisterRequest request) {

        String loginId = request.getLoginId();
        String email = request.getEmail();
        String password = request.getPassword();

        User user = authFacade.register(loginId, email, password);
        return ResponseEntity.ok(user);
    }
}
