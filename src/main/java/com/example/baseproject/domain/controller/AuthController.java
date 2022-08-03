package com.example.baseproject.domain.controller;

import com.example.baseproject.domain.controller.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.dto.request.UserRequest;
import com.example.baseproject.domain.controller.dto.response.IssueTokenResponse;
import com.example.baseproject.domain.controller.dto.response.MessageResponse;
import com.example.baseproject.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse join(@RequestBody UserRequest request){
        return authService.join(request);
    }

    @PostMapping("/login")
    public IssueTokenResponse login(@RequestBody LoginUserRequest request){
        return authService.login(request);
    }

    @PostMapping("/re-issue")
    public IssueTokenResponse refresh(@RequestBody ReIssueTokenRequest request){
        return authService.refreshToken(request);
    }

    @PatchMapping("/compilation")
    public MessageResponse compilation(@RequestBody UserRequest request){
        return authService.editMember(request);
    }
}
