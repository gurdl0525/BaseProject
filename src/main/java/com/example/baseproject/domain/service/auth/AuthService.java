package com.example.baseproject.domain.service.auth;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.auth.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.auth.dto.response.IssueTokenResponse;

public interface AuthService {

    IssueTokenResponse login(LoginUserRequest request);

    IssueTokenResponse refreshToken(ReIssueTokenRequest request);
}
