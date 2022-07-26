package com.example.refreshtoken.domain.controller;

import com.example.refreshtoken.domain.controller.dto.request.LoginUserRequest;
import com.example.refreshtoken.domain.controller.dto.request.ReIssueTokenRequest;
import com.example.refreshtoken.domain.controller.dto.request.UserRequest;
import com.example.refreshtoken.domain.controller.dto.response.IssueTokenResponse;
import com.example.refreshtoken.domain.controller.dto.response.MessageResponse;
import com.example.refreshtoken.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse join(@RequestBody UserRequest request){
        return userService.join(request);
    }
    @PostMapping("/login")
    public IssueTokenResponse login(@RequestBody LoginUserRequest request){
        return userService.login(request);
    }
    @PostMapping("/re-issue")
    public IssueTokenResponse refresh(@RequestBody ReIssueTokenRequest request){
        return userService.refreshToken(request);
    }

}
