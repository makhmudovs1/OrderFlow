package com.orderflowbackend.services;

import com.orderflowbackend.dto.RegistrationRequest;
import com.orderflowbackend.models.Client;
import com.orderflowbackend.models.Role;
import com.orderflowbackend.models.User;
import com.orderflowbackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDetailsService userDetailsService() {
        return this::getUserByUsername;
    }

    public String registerClient(RegistrationRequest request) {
        // Проверка на уникальность email и username
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already in use";
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username already in use";
        }

        // Создаем нового клиента
        Client client = new Client();
        client.setUsername(request.getUsername());
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setRole(Role.CLIENT);

        client.setFirstname(request.getFirstname());
        client.setLastname(request.getLastname());

        userRepository.save(client);

        return "Successfully registered";
    }
}
