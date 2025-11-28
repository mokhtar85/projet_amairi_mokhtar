package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.dto.ClientCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ClientUpdateDTO;

import java.util.List;

public interface ClientService {

     ClientCreateDTO createClient(ClientCreateDTO clientCreateDTO);
     ClientCreateDTO updateClient(Long id,ClientUpdateDTO clientUpdateDTO);
     ClientCreateDTO getClient(Long id);
     List<ClientCreateDTO> getAllClients();
     void deleteClient(Long id);
}
