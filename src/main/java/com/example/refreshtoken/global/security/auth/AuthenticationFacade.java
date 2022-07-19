package com.example.refreshtoken.global.security.auth;

import com.example.refreshtoken.domain.entity.user.User;
import com.example.refreshtoken.domain.entity.user.UserRepository;
import com.example.refreshtoken.global.error.exception.BaseException;
import com.example.refreshtoken.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {
    private final UserRepository userRepository;
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        return userRepository.findByAccountId(authDetails.getUsername())
                .orElseThrow(() -> new BaseException(ErrorCode.NOT_FOUND_USER));
    }
}