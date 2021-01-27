package com.example.auth.core.security.jwt;

import com.example.auth.core.security.AuthenticationToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 26.
 */
@Slf4j
public class JwtToken implements AuthenticationToken<Claims> {
    @Getter
    private final String token;
    private final Key key;

    private static final String AUTHORITIES_KEY = "role";


    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Claims getData() {
        try {
            // ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        //ToDo 에러별 커스텀 메시지 정의
        } catch (MalformedJwtException e) {
            log.error("MalformedJwtException");
            throw e; // Custom Exception 으로 교체 혹은 메시지 지정
        } catch (ExpiredJwtException e) {
            log.error("ExpiredJwtException");
            throw e;
        } catch (UnsupportedJwtException e) {
            log.error("UnsupportedJwtException");
            throw e;
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException");
            throw e;
        } catch (SignatureException e) {
            log.error("SignatureException");
            throw e;
        }
    }

    @Override
    public Optional<String> createToken(String userId, String role, Date expiredDate) {
        var token = Jwts.builder()
                .setSubject(userId)
                .claim(AUTHORITIES_KEY, role)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(expiredDate)
                .compact();
        return Optional.ofNullable(token);
    }


    private JwtToken(String token, Key key) {
        this.token = token;
        this.key = key;
    }

    @Builder
    public JwtToken(String id, String role, Date expiredDate, Key key) {
        this.key = key;
        this.token = createToken(id, role, expiredDate).get();
    }
}
