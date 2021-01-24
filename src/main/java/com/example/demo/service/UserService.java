package com.example.demo.service;

import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.entity.User;
import com.example.demo.enums.UserRole;
import com.example.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

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
                .roles(Collections.singletonList(UserRole.USER)) // 최초 가입시 USER 로 설정
                .build());
    }

    public String login(Map<String, String> user) {
        User member = userRepo.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("user.incorrect.email"));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("user.incorrect.password");
        }
        return jwtTokenProvider.createToken(
                        member.getUsername(), member.getRoles());
    }

}
