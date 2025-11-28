package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.dto.ClientCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ClientUpdateDTO;
import com.example.projet_amairi_mokhtar.entity.CarteBancaire;
import com.example.projet_amairi_mokhtar.entity.Client;
import com.example.projet_amairi_mokhtar.entity.Conseiller;
import com.example.projet_amairi_mokhtar.mapper.ClientMapper;
import com.example.projet_amairi_mokhtar.repository.CarteBancaireRepository;
import com.example.projet_amairi_mokhtar.repository.ClientRepository;
import com.example.projet_amairi_mokhtar.repository.ConseillerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl  implements ClientService {
    private final ClientRepository clientRepository;
    private final ConseillerRepository conseillerRepository;
    private final ClientMapper clientMapper;
    private final CarteBancaireRepository carteBancaireRepository;

    public ClientCreateDTO createClient(ClientCreateDTO clientCreateDTO) {
        Conseiller conseiller = null;
        if (clientCreateDTO.getConseillerId() != null) {
            conseiller = conseillerRepository.findById(clientCreateDTO.getConseillerId())
                    .orElseThrow(() -> new EntityNotFoundException("Conseiller non trouvé"));

            if (conseiller.getClients().size() >= 10) {
                throw new RuntimeException("Ce conseiller a atteint son quota maximum de 10 clients.");
            }        }

        Client client = clientMapper.toEntity(clientCreateDTO, conseiller);
        Client savedClient = clientRepository.save(client);

        return clientMapper.toDto(savedClient);
    }

    @Override
    public ClientCreateDTO updateClient(Long id,ClientUpdateDTO clientUpdateDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable"));

        existingClient.setNom(clientUpdateDTO.getNom());
        existingClient.setPrenom(clientUpdateDTO.getPrenom());
        existingClient.setAdresse(clientUpdateDTO.getAdresse());
        existingClient.setVille(clientUpdateDTO.getVille());
        existingClient.setTelephone(clientUpdateDTO.getTelephone());


        Client updatedClient = clientRepository.save(existingClient);
        return clientMapper.toDto(updatedClient);
    }


    public ClientCreateDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id : " + id));
        return clientMapper.toDto(client);
    }

    public List<ClientCreateDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable"));

        if (client.getCartesBancaires() != null) {
            for (CarteBancaire carte : client.getCartesBancaires()) {
                carte.setActive(false);
                carte.setClient(null);
                carteBancaireRepository.save(carte);
            }
        }
        clientRepository.delete(client);
    }

}
