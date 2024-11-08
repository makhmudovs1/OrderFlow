package com.orderflowbackend.services;

import com.orderflowbackend.models.Admin;
import com.orderflowbackend.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Получение всех администраторов
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Получение администратора по ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Создание нового администратора
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Обновление существующего администратора
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Удаление администратора по ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
