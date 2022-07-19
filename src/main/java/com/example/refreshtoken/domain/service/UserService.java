package com.example.refreshtoken.domain.service;

import com.example.refreshtoken.domain.controller.dto.request.UserRequest;
import com.example.refreshtoken.domain.controller.dto.response.MessageResponse;
import com.example.refreshtoken.domain.entity.user.User;
import com.example.refreshtoken.domain.entity.user.UserRepository;
import com.example.refreshtoken.global.error.exception.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;
    public MessageResponse join(UserRequest request){
        userRepository.findByAccountId(request.getAccountId())
                .ifPresent(user -> {
                    throw DuplicateMemberException.getInstance();
                });
        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return MessageResponse.builder()
                .message("회원가입 완료")
                .build();
    }
}
