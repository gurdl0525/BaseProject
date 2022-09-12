package com.example.baseproject.global.config.security.auth;

import com.example.baseproject.domain.user.member.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByAccountId(username)
                .map(AuthDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("NOT FOUND USERNAME"));
    }
}