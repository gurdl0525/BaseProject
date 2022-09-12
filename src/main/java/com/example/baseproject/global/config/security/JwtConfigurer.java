package com.example.baseproject.global.config.security;

import com.example.baseproject.domain.user.auth.exception.UnAuthorizedTokenException;
import com.example.baseproject.global.error.ExceptionHandlerFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
    private final JwtTokenProvider jwtTokenProvider;
    private final ExceptionHandlerFilter exceptionHandlerFilter;
    @Override
    public void configure(HttpSecurity builder) throws UnAuthorizedTokenException {
        var jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionHandlerFilter, JwtTokenFilter.class);
    }
}
