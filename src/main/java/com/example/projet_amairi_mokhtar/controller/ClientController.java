package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.dto.ClientCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ClientUpdateDTO;
import com.example.projet_amairi_mokhtar.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @PostMapping
    public ResponseEntity<ClientCreateDTO> createClient(@RequestBody ClientCreateDTO clientCreateDTO) {
        ClientCreateDTO createdClient = clientService.createClient(clientCreateDTO);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ClientCreateDTO>> getAllClients() {
        List<ClientCreateDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientCreateDTO> getClient(@PathVariable Long id) {
        ClientCreateDTO client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientCreateDTO> updateClient(
            @PathVariable Long id,
            @RequestBody ClientUpdateDTO clientUpdateDTO) {

        ClientCreateDTO updatedClient = clientService.updateClient(id, clientUpdateDTO);

        return ResponseEntity.ok(updatedClient);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);
        return ResponseEntity.ok("Le client avec l'id " + id + " a été supprimé avec succès.");    }
}
