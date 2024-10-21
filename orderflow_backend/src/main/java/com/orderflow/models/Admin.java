package com.orderflow.models;

public class Admin extends User {

    public Admin() {
        super();
        this.setRole(Role.ADMIN);
    }
}
