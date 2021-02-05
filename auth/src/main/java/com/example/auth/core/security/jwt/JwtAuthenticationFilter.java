package com.example.auth.core.security.jwt;

import com.example.auth.exception.exceptions.NoSuchHeaderException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final String TOKEN_HEADER = "X-AUTH_TOKEN";
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Optional<String> token = extractToken((HttpServletRequest) request);
        if (token.isPresent()) {
            JwtToken jwtToken = jwtTokenProvider.convert(token.get());
            authenticate(jwtToken);
        }

        chain.doFilter(request, response);
    }

    /**
     * Reqeust Header 에서 토큰 추출
     * @param request
     * @return
     */
    private Optional<String> extractToken(HttpServletRequest request) {
        try {
            String authToken = request.getHeader(TOKEN_HEADER);
            if (StringUtils.hasText(authToken)) {
                return Optional.of(authToken);
            }
            return Optional.empty();

        }catch (NullPointerException e) {
            log.info("Match Header Not Exist -> Can not Authenticate");
            return Optional.empty();
        }
    }

    /**
     * 토큰이 유효하면 유저 조회 후 권한 정보 Context 저장
     * @param jwtToken
     */
    private void authenticate(JwtToken jwtToken) {
        if(jwtToken.validate()) {
            Authentication authentication = jwtTokenProvider.extractAuthentication(jwtToken);
            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }
    }

}