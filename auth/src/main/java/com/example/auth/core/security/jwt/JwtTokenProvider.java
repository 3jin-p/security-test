package com.example.auth.core.security.jwt;

import com.example.common.enums.UserRole;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.Set;

/**
 * <b>
 *     JwtToken 객체 생성을 위한 Class
 * </b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
@Component
@RequiredArgsConstructor
public class JwtTokenProvider implements TokenProvider<JwtToken>{

    @Value("${jwt.token.creation.secretkey}")
    private String secret;
    private Key key;

    private final UserDetailsService userDetailsService;
    private final long TOKEN_VALID_TIME = 60 * 60 * 12 * 1000L;

    @PostConstruct
    private void init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public JwtToken create(String id, Collection<UserRole> roles) {
        Date now = new Date();
        return JwtToken.builder()
                .id(id)
                .roles(roles)
                .expiredDate(new Date(now.getTime() + TOKEN_VALID_TIME))
                .key(key).build();
    }

    @Override
    public JwtToken convert(String token) {
        return JwtToken.of(token, key);
    }


    public Authentication extractAuthentication(JwtToken jwtToken) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtToken.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
