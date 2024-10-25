package com.orderflow.orderflowbackend.repositories;

import com.orderflow.orderflowbackend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
