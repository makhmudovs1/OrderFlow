package com.orderflowbackend.controllers.security.dto;

import com.orderflowbackend.controllers.security.validation.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign up request")
public class SignUpRequest {

    @Schema(description = "First name", example = "Jon")
    @NotBlank(message = "First name is required")
    private String firstname;

    @Schema(description = "Last name", example = "Doe")
    // @NotBlank(message = "Last name is required")
    private String lastname;

    @Schema(description = "Username", example = "jondoe12")
    @Size(min = 5, max = 20, message = "Username has to contain from 5 to 20 symbols.")
    @NotBlank(message = "Username can't be empty.")
    private String username;

    @Schema(description = "Email address", example = "jondoe@gmail.com")
    @NotBlank(message = "Email address can't be empty.")
    @Email(message = "Email should be in format user@example.com")
    private String email;

    @Schema(description = "Password", example = "JonDoe123*")
    @ValidPassword
    @NotBlank(message = "Password can't be empty.")
    private String password;

    @NotBlank(message = "Confirm password can't be empty.")
    private String confirmPassword;

    @Schema(description = "Phone number", example = "+99299999999")
    // чуть позже напишу регулярку для проверки номера
    private String phone;

    @AssertTrue(message = "Passwords are not matched.")
    private boolean isPasswordMatch() {
        return password.equals(confirmPassword);
    }
}
