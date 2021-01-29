package com.example.auth.core.service;

import com.example.auth.core.security.jwt.AuthenticationToken;
import com.example.auth.core.security.jwt.JwtTokenProvider;
import com.example.common.entity.User;
import com.example.common.enums.UserRole;
import com.example.common.repo.UserRepo;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 14.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public User join(Map<String, String> user) {
        return userRepo.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Set.of(UserRole.USER)) // 최초 가입시 USER 로 설정
                .build());
    }

    public AuthenticationToken<?> login(Map<String, String> user) {
        User member = userRepo.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("user.incorrect.email"));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("user.incorrect.password");
        }
        return jwtTokenProvider.create(member.getUsername(), member.getRoles());
    }

}
