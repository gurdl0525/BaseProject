package com.example.baseproject.domain.service;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.auth.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.auth.dto.request.UserRequest;
import com.example.baseproject.domain.controller.auth.dto.response.IssueTokenResponse;
import com.example.baseproject.domain.controller.auth.dto.response.MessageResponse;

public interface AuthService {

    MessageResponse join(UserRequest request);

    IssueTokenResponse login(LoginUserRequest request);

    IssueTokenResponse refreshToken(ReIssueTokenRequest request);

    MessageResponse editMember(UserRequest request);
}
