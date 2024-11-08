package com.orderflowbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Admin extends User {

    public Admin() {
        super();
        this.setRole(Role.ADMIN);
    }
}