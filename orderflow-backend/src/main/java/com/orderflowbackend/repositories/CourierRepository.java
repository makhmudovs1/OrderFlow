package com.orderflowbackend.repositories;

import com.orderflowbackend.models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
