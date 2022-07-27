package com.example.refreshtoken.domain.service;

import com.example.refreshtoken.domain.controller.dto.request.LoginUserRequest;
import com.example.refreshtoken.domain.controller.dto.request.ReIssueTokenRequest;
import com.example.refreshtoken.domain.controller.dto.request.UserRequest;
import com.example.refreshtoken.domain.controller.dto.response.IssueTokenResponse;
import com.example.refreshtoken.domain.controller.dto.response.MessageResponse;
import com.example.refreshtoken.domain.entity.redis.RefreshToken;
import com.example.refreshtoken.domain.entity.redis.RefreshTokenRepository;
import com.example.refreshtoken.domain.entity.user.User;
import com.example.refreshtoken.domain.entity.user.UserRepository;
import com.example.refreshtoken.global.error.exception.DuplicateMemberException;
import com.example.refreshtoken.global.error.exception.PasswordInconsistencyException;
import com.example.refreshtoken.global.error.exception.UnAuthorizedTokenException;
import com.example.refreshtoken.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    public MessageResponse join(UserRequest request){
        userRepository.findByAccountId(request.getAccountId())
                .ifPresent(user -> {
                    throw DuplicateMemberException.getInstance();
                });
        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return MessageResponse.builder()
                .message("회원가입 완료")
                .build();
    }
    public IssueTokenResponse login(LoginUserRequest request){
        User user = verifyUser(request);
        IssueTokenResponse response = generateIssueTokenResponse(user);
        refreshTokenRepository.save(new RefreshToken(user.getAccountId(), response.getRefreshToken()));
        return response;
    }
    private User verifyUser(LoginUserRequest request){
        return userRepository.findByAccountId(request.getAccountId())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .orElseThrow(PasswordInconsistencyException::getInstance);
    }
    private IssueTokenResponse generateIssueTokenResponse(User user){
        return IssueTokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getAccountId()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(user.getAccountId()))
                .build();
    }
    public IssueTokenResponse refreshToken(ReIssueTokenRequest request){
        String refreshToken = request.getRefreshToken();
        String userId = jwtTokenProvider.getUserId(refreshToken);
        refreshTokenRepository.findById(userId)
                .filter(rf ->  rf.getRefreshToken().equals(refreshToken))
                .orElseThrow(UnAuthorizedTokenException::getInstance);
        return IssueTokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(userId))
                .refreshToken(refreshToken)
                .build();
    }
}
