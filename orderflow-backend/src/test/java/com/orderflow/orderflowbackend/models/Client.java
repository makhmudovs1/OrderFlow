package com.orderflow.orderflowbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client extends User {

    private String firstName;
    private String lastName;

    public Client() {
        super();
        this.setRole(Role.CLIENT);
    }

    public Client(String username, String password, String email, String phone) {
        this();
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
    }
}
