package com.orderflowbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Courier extends User {

    public Courier() {
        super();
        this.setRole(Role.COURIER);
    }
}
