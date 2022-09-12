package com.example.baseproject.global.util;

import com.example.baseproject.global.error.exception.NotFoundException;
import com.example.baseproject.domain.user.member.entity.User;
import com.example.baseproject.domain.user.member.entity.UserRepository;
import com.example.baseproject.global.config.security.auth.AuthDetails;
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
                .orElseThrow(NotFoundException::getInstance);
    }
}
