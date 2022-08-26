package com.example.baseproject.domain.controller.auth.dto.request;

import lombok.*;

@Builder
@Getter
public class ReIssueTokenRequest {

    private final String refreshToken;

}
