package com.orderflow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin extends User {

    public Admin() {
        super();
        this.setRole(Role.ADMIN);
    }
}
