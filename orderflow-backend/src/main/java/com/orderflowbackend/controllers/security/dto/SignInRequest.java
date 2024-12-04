package com.orderflowbackend.controllers.security.dto;

import com.orderflowbackend.controllers.security.validation.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Sign in request")
public class SignInRequest {
    @Schema(description = "Username", example = "jondoe12")
    @NotBlank(message = "Username can't be empty.")
    private String username;

    @Schema(description = "Password", example = "JonDoe123*")
    @NotBlank(message = "Password can't be empty.")
    private String password;

}
