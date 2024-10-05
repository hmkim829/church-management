package com.example.serviceauth.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 로그인 ID로 사용자 조회
    Optional<User> findByLoginId(String loginId);

    // 이메일로 사용자 조회
    Optional<User> findByEmail(String email);
}

