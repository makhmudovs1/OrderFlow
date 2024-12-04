package com.orderflowbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="couriers")
public class Courier extends User {
    @Enumerated(EnumType.STRING) //  чтобы в табличке хранилось именно название транспортного средства, а не пронумеровалось
    private VehicleType vehicleType;

}
