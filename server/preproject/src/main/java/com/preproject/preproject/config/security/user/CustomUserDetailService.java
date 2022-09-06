package com.preproject.preproject.config.security.user;

import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.exception.ExceptionCode;
import com.preproject.preproject.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.EMAIL_NOT_FOUND));
    }
}
