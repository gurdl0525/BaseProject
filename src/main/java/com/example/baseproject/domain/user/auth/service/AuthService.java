package com.example.baseproject.domain.user.auth.service;

import com.example.baseproject.domain.user.auth.dto.LoginUserRequest;
import com.example.baseproject.domain.user.auth.dto.ReIssueTokenRequest;
import com.example.baseproject.domain.user.auth.dto.IssueTokenResponse;
import com.example.baseproject.domain.user.auth.dto.ReIssueTokenResponse;

public interface AuthService {

    IssueTokenResponse login(LoginUserRequest request);

    ReIssueTokenResponse refreshToken(ReIssueTokenRequest request);
}
