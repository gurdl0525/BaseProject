package com.example.baseproject.domain.controller.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReIssueTokenResponse {

    private String accessToken;

    private String refreshToken;

}
