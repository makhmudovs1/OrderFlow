package com.orderflow.services;

import com.orderflow.dto.RegistrationRequest;
import com.orderflow.models.Client;
import com.orderflow.models.Role;
import com.orderflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    // Используется для шифрования пароля перед сохранением
    private PasswordEncoder passwordEncoder;

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

        client.setFirstName(request.getFirstname());
        client.setLastName(request.getLastname());

        userRepository.save(client);

        return "Successfully registered";
    }
}
