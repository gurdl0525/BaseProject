package com.example.baseproject.global.config.security;

import com.example.baseproject.domain.user.auth.exception.UnAuthorizedTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            String token = jwtTokenProvider.resolveToken(request);
            if(token != null && jwtTokenProvider.validateToken(token)){
                var auth = jwtTokenProvider.authentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (UnAuthorizedTokenException e){
            SecurityContextHolder.clearContext();
        }
        chain.doFilter(request, response);
    }
}
