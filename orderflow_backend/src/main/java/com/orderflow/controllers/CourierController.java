package com.orderflow.controllers;

import com.orderflow.models.Courier;
import com.orderflow.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    @Autowired
    private CourierService courierService;

    // Получение всех курьеров
    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    // Получение курьера по ID
    @GetMapping("/{id}")
    public Optional<Courier> getCourierById(@PathVariable Long id) {
        return courierService.getCourierById(id);
    }

    // Создание нового курьера
    @PostMapping
    public Courier createCourier(@RequestBody Courier courier) {
        return courierService.createCourier(courier);
    }

    // Обновление курьера
    @PutMapping("/{id}")
    public Courier updateCourier(@PathVariable Long id, @RequestBody Courier courierDetails) {
        Courier courier = courierService.getCourierById(id)
                .orElseThrow(() -> new RuntimeException("Courier not found with id " + id));

        // Обновляем поля
        courier.setEmail(courierDetails.getEmail());
        courier.setPhone(courierDetails.getPhone());
        courier.setUsername(courierDetails.getUsername());
        courier.setPassword(courierDetails.getPassword());

        // Сохраняем изменения
        return courierService.updateCourier(courier);
    }

    // Удаление курьера
    @DeleteMapping("/{id}")
    public String deleteCourier(@PathVariable Long id) {
        courierService.deleteCourier(id);
        return "Courier with id " + id + " has been deleted.";
    }
}
