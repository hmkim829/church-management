package com.example.serviceauth.controller;

import com.example.serviceauth.controller.request.AuthRegisterRequest;
import com.example.serviceauth.facade.AuthFacade;
import com.example.serviceauth.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    // 회원가입 엔드포인트
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRegisterRequest request) {

        String loginId = request.getLoginId();
        String email = request.getEmail();
        String password = request.getPassword();

        User user = authFacade.register(loginId, email, password);
        return ResponseEntity.ok(user);
    }
}
