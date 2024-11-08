package com.orderflowbackend.repositories;

import com.orderflowbackend.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
