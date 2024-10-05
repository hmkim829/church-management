package com.example.serviceauth.application.service;

import com.example.serviceauth.domain.user.User;
import com.example.serviceauth.domain.user.UserRepository;
import com.example.serviceauth.common.exception.AuthErrorCode;
import com.example.serviceauth.common.exception.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(String loginId, String email, String rawPassword) {

        // 중복된 loginId 확인
        if (userRepository.findByLoginId(loginId).isPresent()) {
            throw new AuthException(AuthErrorCode.LOGIN_ID_ALREADY_EXISTS);
        }

        // 중복된 email 확인
        if (userRepository.findByEmail(email).isPresent()) {
            throw new AuthException(AuthErrorCode.EMAIL_ALREADY_EXISTS);
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 사용자 저장
        User user = User.builder()
                .loginId(loginId)
                .email(email)
                .password(encodedPassword)
                .build();

        return userRepository.save(user);
    }
}
