package com.example.baseproject.global.security.auth;

import com.example.baseproject.domain.entity.user.User;
import com.example.baseproject.domain.entity.user.UserRepository;
import com.example.baseproject.global.error.exception.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails)authentication.getPrincipal();
        return userRepository.findByAccountId(authDetails.getUsername())
                .orElseThrow(NotFoundUserException::getInstance);
    }
}
