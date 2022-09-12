package com.example.baseproject.domain.user.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReIssueTokenResponse {

    private String accessToken;

    private String refreshToken;

}
