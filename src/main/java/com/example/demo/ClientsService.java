package com.example.demo;

import com.example.demo.Clients;
import com.example.demo.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> selectAllClients(){
        return clientsRepository.findAll();
    }

    public Clients saveClient(Clients clients){
        return clientsRepository.save(clients);
    }

    public void deleteClientById(Long id) {
        clientsRepository.deleteById(id);
    }

    public Optional<Clients> getClientById(Long id){
        return clientsRepository.findById(id);
    }

}
