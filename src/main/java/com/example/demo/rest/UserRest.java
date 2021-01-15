package com.example.demo.rest;

import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.dto.TokenResponse;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */

@RequiredArgsConstructor
@RestController
public class UserRest {

    private final UserService userService;
    private final ModelMapper defaultModelMapper;

    // 회원가입
    @PostMapping("/join")
    public UserDTO.Info join(@RequestBody Map<String, String> user) {
        return defaultModelMapper.map(
                userService.join(user), UserDTO.Info.class);
    }

    // 로그인
    @PostMapping("/login")
    public TokenResponse login(@RequestBody Map<String, String> user) {
        return TokenResponse.of(userService.login(user));
    }

}