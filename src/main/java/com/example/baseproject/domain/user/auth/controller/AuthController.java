package com.example.baseproject.domain.user.auth.controller;

import com.example.baseproject.domain.user.auth.dto.LoginUserRequest;
import com.example.baseproject.domain.user.auth.dto.ReIssueTokenRequest;
import com.example.baseproject.domain.user.auth.dto.IssueTokenResponse;
import com.example.baseproject.domain.user.auth.dto.ReIssueTokenResponse;
import com.example.baseproject.domain.user.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public IssueTokenResponse login(@RequestBody LoginUserRequest request){
        return authService.login(request);
    }

    @PostMapping("/re-issue")
    public ReIssueTokenResponse refresh(@RequestBody ReIssueTokenRequest request){
        return authService.refreshToken(request);
    }
}
