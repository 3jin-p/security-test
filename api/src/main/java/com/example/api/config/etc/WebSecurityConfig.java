package com.example.api.config.etc;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/**
 * <b>
 *     Spring Security Configuration
 * </b>
 *
 * @author sejinpark
 * @since 21. 1. 11.
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 를 사용할것이므로 Stateless
                .and()
                .authorizeRequests()
//                .antMatchers("/admin/**").hasAuthority(UserRole.ADMIN.value)
//                .antMatchers("/user/**").hasAuthority(UserRole.USER.value)
                .anyRequest().permitAll()
                .and()
                .headers()
                .addHeaderWriter(
                        new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'"))
                .frameOptions().disable();
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

}
