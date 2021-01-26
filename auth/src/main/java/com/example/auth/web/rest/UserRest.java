package com.example.auth.web.rest;

import com.example.auth.web.rest.dto.TokenDTO;
import com.example.auth.web.rest.dto.UserDTO;
import com.example.auth.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

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
    public TokenDTO login(@RequestBody Map<String, String> user) {
        return TokenDTO.of(userService.login(user));
    }

    @PostMapping("login/oauth2")
    public void loginByOauth() {

    }

}