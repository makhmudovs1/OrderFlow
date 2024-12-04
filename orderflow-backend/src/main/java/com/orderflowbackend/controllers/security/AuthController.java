package com.orderflowbackend.controllers.security;

import com.orderflowbackend.controllers.security.dto.JwtResponse;
import com.orderflowbackend.controllers.security.dto.RefreshTokenRequest;
import com.orderflowbackend.controllers.security.dto.SignInRequest;
import com.orderflowbackend.controllers.security.dto.SignUpRequest;
import com.orderflowbackend.useCases.auth.refreshToken.RefreshTokenHandler;
import com.orderflowbackend.useCases.auth.signIn.SignInHandler;
import com.orderflowbackend.useCases.auth.signUp.SignUpHandler;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {
    private final SignUpHandler signUpHandler;
    private final SignInHandler signInHandler;
    private final RefreshTokenHandler refreshTokenHandler;

    @Operation(summary = "User sign up")
    @PostMapping("/sign-up")
    public JwtResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        // текучий интерфейс называется такой подход
        var command = com.orderflowbackend.useCases.auth.signUp.Command.builder()
                .firstname(signUpRequest.getFirstname())
                .lastname(signUpRequest.getLastname())
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .email(signUpRequest.getEmail())
                .phone(signUpRequest.getPhone())
                .build();
        var jwtPair = signUpHandler.handle(command);
        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }


    @Operation(summary = "User sign in")
    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        var command = com.orderflowbackend.useCases.auth.signIn.Command.builder()
                .username(signInRequest.getUsername())
                .password(signInRequest.getPassword())
                .build();
        var jwtPair = signInHandler.handle(command);
        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }

    @Operation(summary = "Refresh Token")
    @PostMapping("/refresh-token")
    public JwtResponse refreshToken(@RequestBody @Valid RefreshTokenRequest refreshTokenRequest) {

        var command = com.orderflowbackend.useCases.auth.refreshToken.Command.builder()
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .build();
        var jwtPair = refreshTokenHandler.handle(command);
        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }
}
