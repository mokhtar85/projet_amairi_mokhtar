package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.dto.ConseillerCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ConseillerDTO;
import com.example.projet_amairi_mokhtar.entity.Conseiller;
import com.example.projet_amairi_mokhtar.mapper.ConseillerMapper;
import com.example.projet_amairi_mokhtar.repository.ConseillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {
    private final ConseillerRepository conseillerRepository;
    private final ConseillerMapper conseillerMapper;

    public ConseillerDTO createConseiller(ConseillerCreateDTO createDTO) {
        Conseiller conseiller = conseillerMapper.toEntity(createDTO);

        Conseiller savedConseiller = conseillerRepository.save(conseiller);
        return conseillerMapper.toDto(savedConseiller);    }

    @Override
    public List<ConseillerDTO> getAllConseillers() {
        return conseillerRepository.findAll()
                .stream()
                .map(conseillerMapper::toDto)
                .collect(Collectors.toList());
    }
}
