package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientsController {

    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping("/clientsList")
    public List<Clients> getAllClients(){
        return clientsService.selectAllClients();
    }

    @GetMapping("/clientsList/search/{id}")
    public Optional<Clients> searchClientsById(@PathVariable("id") long id){
        return clientsService.getClientById(id);
    }

    @DeleteMapping("/clientsList/delete/{id}")
    public ResponseEntity<String> deleteClientsById(@PathVariable("id") long id){
        Optional<Clients> client = clientsService.getClientById(id);

        if (client.isPresent()) {
            clientsService.deleteClientById(id);
            return ResponseEntity.ok("Client with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clientsList/add")
    public ResponseEntity<String> addClient(@RequestBody Clients client) {
        try {
            clientsService.saveClient(client);
            return ResponseEntity.ok("Client added successfully.");
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error adding client: " + ex.getMessage());
        }
    }

}
