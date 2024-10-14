package com.orderflow.controllers;

import com.orderflow.dto.RegistrationRequest;
import com.orderflow.models.Client;
import com.orderflow.models.Role;
import com.orderflow.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Обозначает класс как контроллер, в котором каждый метод возвращает объект вместо представления.
@RequestMapping("api/auth")
// Устанавливает базовый URL для всех методов в этом контроллере.
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    // Используется для шифрования пароля перед сохранением
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    // Метод registerUser обрабатывает POST-запрос на /api/auth/register.
    public String registerUser(@Valid @RequestBody RegistrationRequest request) {
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
