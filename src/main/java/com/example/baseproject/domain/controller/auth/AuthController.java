package com.example.baseproject.domain.controller.auth;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.auth.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.auth.dto.response.IssueTokenResponse;
import com.example.baseproject.domain.controller.auth.dto.response.ReIssueTokenResponse;
import com.example.baseproject.domain.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public IssueTokenResponse login(@RequestBody LoginUserRequest request){
        return authService.login(request);
    }

    @PostMapping("/re-issue")
    public ReIssueTokenResponse refresh(@RequestBody ReIssueTokenRequest request){
        return authService.refreshToken(request);
    }
}
