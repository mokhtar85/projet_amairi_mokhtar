package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.entity.Compte;
import com.example.projet_amairi_mokhtar.entity.CompteCourant;
import com.example.projet_amairi_mokhtar.repository.CompteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VirementServiceImpl implements VirementService {

    private final CompteRepository compteRepository;


    @Transactional
    public void effectuerVirement(Long idSource, Long idDest, double montant) {

        if (idSource.equals(idDest)) {
            throw new IllegalArgumentException("impossible d'effectuer des virement pour le meme compte.");
        }
        if (montant <= 0) {
            throw new IllegalArgumentException("montant doit etre positif");
        }

        Compte source = compteRepository.findById(idSource)
                .orElseThrow(() -> new EntityNotFoundException("Compte source introuvable (ID: " + idSource + ")"));

        Compte destination = compteRepository.findById(idDest)
                .orElseThrow(() -> new EntityNotFoundException("Compte destination introuvable (ID: " + idDest + ")"));

        double soldeDisponible = source.getSolde();

        if (source instanceof CompteCourant) {
            CompteCourant cc = (CompteCourant) source;
            soldeDisponible += cc.getDecouvertAutorise();
        }

        if (soldeDisponible < montant) {
            throw new RuntimeException("Solde insuffisant pour ce virement.");
        }

        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);

        compteRepository.save(source);
        compteRepository.save(destination);

    }
}