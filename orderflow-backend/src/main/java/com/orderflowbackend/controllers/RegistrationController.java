package com.orderflowbackend.controllers;

import com.orderflowbackend.dto.RegistrationRequest;
import com.orderflowbackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Обозначает класс как контроллер, в котором каждый метод возвращает объект вместо представления.
@RequestMapping("api/auth")
// Устанавливает базовый URL для всех методов в этом контроллере.
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    // Метод registerUser обрабатывает POST-запрос на /api/auth/register.
    public String registerUser(@Valid @RequestBody RegistrationRequest request) {
        userService.registerClient(request);
        return "Successfully registered";
    }
}
