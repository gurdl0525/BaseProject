package com.example.baseproject.domain.service.auth;

import com.example.baseproject.domain.controller.auth.dto.request.LoginUserRequest;
import com.example.baseproject.domain.controller.auth.dto.request.ReIssueTokenRequest;
import com.example.baseproject.domain.controller.auth.dto.response.IssueTokenResponse;
import com.example.baseproject.domain.controller.auth.dto.response.ReIssueTokenResponse;
import com.example.baseproject.domain.entity.redis.RefreshToken;
import com.example.baseproject.domain.entity.redis.RefreshTokenRepository;
import com.example.baseproject.domain.entity.user.User;
import com.example.baseproject.domain.entity.user.UserRepository;
import com.example.baseproject.global.error.exception.PasswordInconsistencyException;
import com.example.baseproject.global.error.exception.UnAuthorizedTokenException;
import com.example.baseproject.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final RefreshTokenRepository refreshTokenRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
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

    @Override
    public ReIssueTokenResponse refreshToken(ReIssueTokenRequest request){
        String refreshToken = request.getRefreshToken();
        String userId = jwtTokenProvider.getUserId(refreshToken);
        refreshTokenRepository.findById(userId)
                .filter(rf ->  rf.getRefreshToken().equals(refreshToken))
                .orElseThrow(UnAuthorizedTokenException::getInstance);
        return ReIssueTokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(userId))
                .refreshToken(refreshToken)
                .build();
    }
}
