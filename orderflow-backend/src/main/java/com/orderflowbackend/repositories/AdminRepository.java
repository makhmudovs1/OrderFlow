package com.orderflowbackend.repositories;

import com.orderflowbackend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
