package com.orderflowbackend.useCases.auth.signUp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Command {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String phone;
}
