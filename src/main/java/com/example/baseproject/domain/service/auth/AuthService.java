package com.example.baseproject.domain.service.auth;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.auth.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.auth.dto.response.IssueTokenResponse;
import com.example.baseproject.domain.controller.auth.dto.response.ReIssueTokenResponse;

public interface AuthService {

    IssueTokenResponse login(LoginUserRequest request);

    ReIssueTokenResponse refreshToken(ReIssueTokenRequest request);
}
