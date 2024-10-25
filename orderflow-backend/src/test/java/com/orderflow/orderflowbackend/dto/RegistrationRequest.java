package com.orderflow.orderflowbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationRequest {

    // Аннотации валидации (@NotBlank, @Email, @Size) проверяют корректность данных

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "First name is required")
    private String firstname;

    @NotBlank(message = "Last name is required")
    private String lastname;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotBlank(message = "Password is required")
    // Ну это потом поменяем
    @Size(min=6, message = "Password must be at least 6 characters")
    private String password;

    // Поля DTO соответствуют данным, которые клиент отправит для регистрации.
}
