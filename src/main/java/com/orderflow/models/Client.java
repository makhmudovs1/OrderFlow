package com.orderflow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client extends User {

    public Client() {
        super();
        this.setRole(Role.CLIENT);
    }

    public Client(String username, String password, String email, String phone) {
        super(username, password, Role.CLIENT, email, phone);
    }
}
