package com.example.auth.core.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.token.creation.secretKey}")
    private String secret;
    private Key key;

    private final UserDetailsService userDetailsService;

    @PostConstruct
    private void init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public JwtToken createJwtToken(String id, String role, Date expiredDate) {
        return new JwtToken(id, role, expiredDate, key);
    }

    public JwtToken convertAuthToken(String token) {
        return new JwtToken(token, key);
    }


    public Authentication extractAuthentication(JwtToken jwtToken) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtToken.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}