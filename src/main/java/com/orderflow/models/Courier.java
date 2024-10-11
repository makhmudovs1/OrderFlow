package com.orderflow.models;

public class Courier extends User {

    public Courier() {
        super();
        this.setRole(Role.COURIER);
    }
}
