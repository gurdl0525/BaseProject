package com.example.baseproject.domain.user.member.service;

import com.example.baseproject.domain.user.auth.dto.LoginUserRequest;
import com.example.baseproject.domain.user.member.dto.CreateUserRequest;
import com.example.baseproject.global.common.MessageResponse;

public interface UserService {

    MessageResponse join(CreateUserRequest request);

    MessageResponse editMember(LoginUserRequest request);
}
