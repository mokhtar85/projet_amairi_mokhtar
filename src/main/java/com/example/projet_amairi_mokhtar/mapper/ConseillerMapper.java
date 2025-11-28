package com.example.projet_amairi_mokhtar.mapper;


import com.example.projet_amairi_mokhtar.dto.ConseillerCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ConseillerDTO;
import com.example.projet_amairi_mokhtar.entity.Conseiller;
import org.springframework.stereotype.Component;

@Component
public class ConseillerMapper {

    public ConseillerDTO toDto(Conseiller entity) {
        if (entity == null) return null;
        return ConseillerDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .build();
    }

    public Conseiller toEntity(ConseillerCreateDTO dto) {
        if (dto == null) return null;
        return Conseiller.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .build();
    }
}