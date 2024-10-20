package com.orderflow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Courier extends User {

    public Courier() {
        super();
        this.setRole(Role.COURIER);
    }
}
