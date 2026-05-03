package com.example.demo.service;

import com.example.demo.dto.LoginUserDto;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthenticationServiceImpl {
    private final AccountRepository AccountRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(
            AccountRepository accountRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.AccountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public User signup(RegisterUserDto input) {
//        User user = new User()
//                .setFullName(input.getFullName())
//                .setEmail(input.getEmail())
//                .setPassword(passwordEncoder.encode(input.getPassword()));
//
//        return AccountRepository.save(user);
//    }

    public Account authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return AccountRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}