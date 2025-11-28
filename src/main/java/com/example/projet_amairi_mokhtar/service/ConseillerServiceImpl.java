package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.entity.Conseiller;
import com.example.projet_amairi_mokhtar.repository.ConseillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {
    private final ConseillerRepository conseillerRepository;

    public Conseiller createConseiller(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
    }

    public List<Conseiller> getAllConseillers() {
        return conseillerRepository.findAll();
    }
}
