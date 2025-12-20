package com.example.umc9th2.global.auth;

import com.example.umc9th2.domain.user.entity.User;
import com.example.umc9th2.domain.user.exception.code.UserErrorCode;
import com.example.umc9th2.domain.user.repository.UserRepository;
import com.example.umc9th2.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new GeneralException(UserErrorCode.USER_NOT_FOUND));
        
        return new CustomUserDetails(user);
    }
}

