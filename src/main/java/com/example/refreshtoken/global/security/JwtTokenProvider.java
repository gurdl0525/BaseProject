package com.example.refreshtoken.global.security;

import com.example.refreshtoken.domain.entity.redis.Redis;
import com.example.refreshtoken.domain.entity.redis.RedisRepository;
import com.example.refreshtoken.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final AuthDetailsService authDetailsService;
    private final RedisRepository redisRepository;
    public String getBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null){
            return null;
        }
        return bearerToken.substring(7);
    }
    public String getUserId(String token){
        try{
            return Jwts.parser().setSigningKey("refreshTokenStudy").parseClaimsJws(token).getBody().getSubject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private String createToken(String accountId,Long ttl){
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .setSubject(accountId)
                .signWith(SignatureAlgorithm.HS256, "refreshTokenStudy")
                .compact();
    }
    public String generateAccessToken(String id){
        String token = createToken(id, 60L * 5);
        if(redisRepository.existsById(id)){
            Redis redis = redisRepository.findById(id).get();
            redis = Redis.builder()
                    .id(redis.getId())
                    .accessToken(token)
                    .refreshToken(redis.getRefreshToken())
                    .exp(redis.getExp())
                    .build();
        }
        return token;
    }
    public String generateRefreshToken(String id){
        return createToken(id, 60L * 60 * 2);
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getUserId(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", null);
    }
}
