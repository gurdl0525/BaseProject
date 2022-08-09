package com.example.baseproject.domain.controller.auth.dto.request;

import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReIssueTokenRequest {

    @NotNull
    private String refreshToken;

}
