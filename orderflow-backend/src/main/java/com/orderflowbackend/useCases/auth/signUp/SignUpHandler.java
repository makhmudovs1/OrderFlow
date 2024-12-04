package com.orderflowbackend.useCases.auth.signUp;

import com.orderflowbackend.models.Role;
import com.orderflowbackend.models.User;
import com.orderflowbackend.repositories.UserRepository;
import com.orderflowbackend.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpHandler {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public Response handle(Command command) {
        var passwordHash = passwordEncoder.encode(command.getPassword());
        var user = User.builder()
                .firstname(command.getFirstname())
                .lastname(command.getLastname())
                .username(command.getUsername())
                .password(passwordHash)
                .email(command.getEmail())
                .role(Role.USER)
                .phone(command.getPhone())
                .build();
        userRepository.save(user);
        var accessToken = jwtService.generateToken(user);
        return new Response(accessToken, "");
    }
}
