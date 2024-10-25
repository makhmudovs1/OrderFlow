package com.orderflow.orderflowbackend.repositories;

import com.orderflow.orderflowbackend.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
