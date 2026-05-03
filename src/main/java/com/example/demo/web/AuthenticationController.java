package com.example.demo.web;

import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.model.Account;
import com.example.demo.service.AuthenticationServiceImpl;
import com.example.demo.utils.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationServiceImpl authenticationServiceImpl;

    public AuthenticationController(JwtService jwtService, AuthenticationServiceImpl authenticationServiceImpl) {
        this.jwtService = jwtService;
        this.authenticationServiceImpl = authenticationServiceImpl;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
//        User registeredUser = authenticationService.signup(registerUserDto);
//
//        return ResponseEntity.ok(registeredUser);
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Account authenticatedUser = authenticationServiceImpl.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}