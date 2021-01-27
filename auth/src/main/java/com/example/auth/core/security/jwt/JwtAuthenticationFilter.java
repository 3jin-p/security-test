package com.example.auth.core.security.jwt;

import com.example.auth.exception.exceptions.NoSuchHeaderException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    @Value("${jwt.token.header.name}")
    private String TOKEN_HEADER;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Optional<String> token = extractToken((HttpServletRequest) request);
        if (token.isPresent()) {
            JwtToken jwtToken = jwtTokenProvider.convertAuthToken(
                    extractToken((HttpServletRequest) request)
                            .orElseThrow(NoSuchHeaderException::new));

            authenticate(jwtToken);
        }

        chain.doFilter(request, response);
    }

    private Optional<String> extractToken(HttpServletRequest request) {
        String authToken = request.getHeader(TOKEN_HEADER);
        if (StringUtils.hasText(authToken)) {
            return Optional.of(authToken);
        }
        return Optional.empty();

    }

    private void authenticate(JwtToken jwtToken) {
        if(jwtToken.validate()) {
            Authentication authentication = jwtTokenProvider.extractAuthentication(jwtToken);
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }
    }

}