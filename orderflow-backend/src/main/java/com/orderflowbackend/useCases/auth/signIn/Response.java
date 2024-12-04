package com.orderflowbackend.useCases.auth.signIn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String accessToken;
    private String refreshToken;

}
