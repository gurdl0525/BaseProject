package com.example.baseproject.domain.service.user;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.user.dto.request.CreateUserRequest;
import com.example.baseproject.domain.controller.user.dto.response.MessageResponse;

public interface UserService {

    MessageResponse join(CreateUserRequest request);

    MessageResponse editMember(LoginUserRequest request);
}
