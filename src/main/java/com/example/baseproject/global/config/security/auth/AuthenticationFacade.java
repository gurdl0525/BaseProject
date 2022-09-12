package com.example.baseproject.global.config.security.auth;

import com.example.baseproject.domain.user.auth.exception.NotFoundUserException;
import com.example.baseproject.domain.user.member.entity.User;
import com.example.baseproject.domain.user.member.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var authDetails = (AuthDetails)authentication.getPrincipal();
        return userRepository.findByAccountId(authDetails.getUsername())
                .orElseThrow(NotFoundUserException::getInstance);
    }
}
