package com.orderflow.orderflowbackend.services;

import com.orderflow.orderflowbackend.models.Courier;
import com.orderflow.orderflowbackend.repositories.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    // Получение всех курьеров
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    // Получение курьера по ID
    public Optional<Courier> getCourierById(Long id) {
        return courierRepository.findById(id);
    }

    // Создание нового курьера
    public Courier createCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    // Обновление существующего курьера
    public Courier updateCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    // Удаление курьера по ID
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
