package com.example.projet_amairi_mokhtar.mapper;

import com.example.projet_amairi_mokhtar.dto.ClientCreateDTO;
import com.example.projet_amairi_mokhtar.entity.Client;
import com.example.projet_amairi_mokhtar.entity.Conseiller;

import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientCreateDTO toDto(Client client) {
        if (client == null) return null;

        return ClientCreateDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .codePostal(client.getCodePostal())
                .ville(client.getVille())
                .telephone(client.getTelephone())
                .conseillerId(client.getConseiller() != null ? client.getConseiller().getId() : null)
                .build();
    }

    public Client toEntity(ClientCreateDTO dto, Conseiller conseiller) {
        if (dto == null) return null;

        return Client.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .adresse(dto.getAdresse())
                .codePostal(dto.getCodePostal())
                .ville(dto.getVille())
                .telephone(dto.getTelephone())
                .conseiller(conseiller)
                .build();
    }
}