package com.orderflowbackend.services;

import com.orderflowbackend.models.Client;
import com.orderflowbackend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Получение всех клиентов
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Получение клиента по ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Создание нового клиента
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Обновление существующего клиента
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    // Удаление клиента по ID
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
