package com.orderflowbackend.controllers;

import com.orderflowbackend.models.Client;
import com.orderflowbackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    // Получение всех клиентов
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Получение клиента по ID
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    // Создание нового клиента
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        // Получаем клиента из базы данных
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id + " + id));

        // Обновляем поля
        client.setFirstname(clientDetails.getFirstname());
        client.setLastname(clientDetails.getLastname());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setUsername(clientDetails.getUsername());
        client.setPassword(clientDetails.getPassword());

        // Сохраняем обновлённого клиента
        return clientService.updateClient(client);
    }

    // Удаление клиента
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "Client with id " + id + " has been deleted.";
    }
}
