package com.example.baseproject.domain.controller.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponse {

    private String accessToken;

}
