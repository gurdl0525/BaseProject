package com.example.baseproject.domain.user.member.service;

import com.example.baseproject.domain.user.auth.dto.LoginUserRequest;
import com.example.baseproject.domain.user.member.dto.CreateUserRequest;
import com.example.baseproject.global.common.MessageResponse;
import com.example.baseproject.domain.user.member.entity.User;
import com.example.baseproject.domain.user.member.entity.UserRepository;
import com.example.baseproject.domain.user.member.exception.DuplicateMemberException;
import com.example.baseproject.global.util.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    private final AuthenticationFacade authenticationFacade;

    @Override
    public MessageResponse join(CreateUserRequest request){
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

    @Override
    public MessageResponse editMember(LoginUserRequest request) {
        User user = authenticationFacade.getCurrentUser();
        userRepository.save(User.builder()
                        .id(user.getId())
                        .accountId(request.getAccountId())
                        .password(request.getPassword())
                .build());
        return MessageResponse.builder()
                .message("회원 정보 수정 완료")
                .build();
    }
}
