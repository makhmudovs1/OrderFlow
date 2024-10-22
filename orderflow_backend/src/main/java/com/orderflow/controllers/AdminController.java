package com.orderflow.controllers;

import com.orderflow.models.Admin;
import com.orderflow.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Получение всех администраторов
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Получение администратора по ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // Создание нового администратора
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    // Обновление администратора
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Admin admin = adminService.getAdminById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));

        // Обновляем поля
        admin.setEmail(adminDetails.getEmail());
        admin.setPhone(adminDetails.getPhone());
        admin.setUsername(adminDetails.getUsername());
        admin.setPassword(adminDetails.getPassword());

        // Сохраняем изменения
        return adminService.updateAdmin(admin);
    }

    // Удаление администратора
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin with id " + id + " has been deleted.";
    }
}
