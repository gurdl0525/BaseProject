package com.example.refreshtoken.domain.entity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Builder
@Getter
@AllArgsConstructor
@RedisHash(value = "refresh_token")
public class Redis {
    @Id
    private final String id;
    @Indexed
    private final String accessToken;
    @Indexed
    private final String refreshToken;
    @TimeToLive
    private final Long exp;
}
