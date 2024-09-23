package com.example.serviceauth.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey secretKey;

    // Spring의 @Value 애노테이션을 사용하여 환경 변수 값을 주입받음
    public JwtTokenProvider(@Value("${jwt.secret}") String secret) {
        // Base64로 인코딩된 secret 값을 SecretKey로 변환
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        this.secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
    }

    private final long validityInMilliseconds = 3600000;  // 1시간

    // JWT 토큰 생성
    public String createToken(String loginId) {
        Claims claims = Jwts.claims().setSubject(loginId);  // 토큰에 사용자 정보를 저장
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);  // 만료 시간 설정

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256)  // SecretKey로 서명
                .compact();
    }

    // JWT 토큰에서 사용자 정보 추출
    public String getLoginId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
