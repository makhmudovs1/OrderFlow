package com.orderflowbackend.controllers.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Response with access token")
public class JwtResponse {
    @Schema(description = "Access Token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
    private String accessToken;
    @Schema(description = "Refresh Token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")
    private String refreshToken;
}
