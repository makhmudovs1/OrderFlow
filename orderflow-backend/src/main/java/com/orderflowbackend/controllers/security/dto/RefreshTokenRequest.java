package com.orderflowbackend.controllers.security.dto;

import com.orderflowbackend.controllers.security.validation.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Refresh token request")
public class RefreshTokenRequest {
    @Schema(description = "Refresh Token")
    @NotBlank(message = "Refresh token can't be empty")
    private String refreshToken;
}
