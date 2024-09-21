-- user 테이블 생성 (login_id로 로그인)
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login_id VARCHAR(50) NOT NULL UNIQUE,  -- 사용자 정의 로그인 ID, UNIQUE 제약조건 추가
    email VARCHAR(100) NOT NULL UNIQUE,    -- 이메일, 중복되지 않도록 UNIQUE 제약조건 추가
    password VARCHAR(100) NOT NULL,        -- 비밀번호
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성 시간
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 수정 시간
);