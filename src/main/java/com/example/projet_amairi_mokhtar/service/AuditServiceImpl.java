package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.entity.Compte;
import com.example.projet_amairi_mokhtar.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private CompteRepository compteRepository;

    public Map<String, Object> genererRapportAudit() {
        List<Compte> listeDesComptes = compteRepository.findAll();

        double totalDebit = 0;
        double totalCredit = 0;

        List<Compte> comptesEnAlerte = new ArrayList<>();
        List<String> messagesAlertes = new ArrayList<>();

        for (Compte compte : listeDesComptes) {
            double solde = compte.getSolde();

            if (solde < 0) {
                totalDebit = totalDebit + solde;
            } else {
                totalCredit = totalCredit + solde;
            }

            if (solde < -5000) {
                comptesEnAlerte.add(compte);

                String message = "Compte " + compte.getNumeroCompte() +
                        " (Client ID: " + compte.getClient().getId() + ") : " +
                        solde + "€";
                messagesAlertes.add(message);


            }
        }

        Map<String, Object> rapport = new HashMap<>();
        rapport.put("total_comptes_analyses", listeDesComptes.size());
        rapport.put("total_debit_banque", totalDebit);
        rapport.put("total_credit_banque", totalCredit);
        rapport.put("nombre_alertes", comptesEnAlerte.size());
        rapport.put("liste_alertes", messagesAlertes);

        return rapport;
    }
}