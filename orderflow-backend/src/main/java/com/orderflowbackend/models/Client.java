package com.orderflowbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Setter
@Getter
public class Client extends User {
    private String address;
}
