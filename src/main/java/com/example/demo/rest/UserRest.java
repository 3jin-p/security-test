package com.example.demo.rest;

import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.dto.TokenResponse;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    private final JwtTokenProvider jwtTokenProvider;

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

    @GetMapping("/user/test")
    public Object getUserFullInfo(@RequestBody TokenResponse tokenResponse) {
       return jwtTokenProvider.getAuthentication(tokenResponse.getToken()).getPrincipal();
    }
}