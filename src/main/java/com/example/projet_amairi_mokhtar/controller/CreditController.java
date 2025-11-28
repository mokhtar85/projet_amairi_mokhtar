package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/simulation")
    public ResponseEntity<Map<String, Object>> simuler(
            @RequestParam double montant,
            @RequestParam double taux,
            @RequestParam int mois) {

        double mensualite = creditService.simulerMensualite(montant, taux, mois);
        double coutTotal = (mensualite * mois) - montant;

        Map<String, Object> resultat = new HashMap<>();
        resultat.put("montant_emprunte", montant);
        resultat.put("taux_annuel", taux);
        resultat.put("duree_mois", mois);
        resultat.put("mensualite_estimee", mensualite);
        resultat.put("cout_total_credit", Math.round(coutTotal * 100.0) / 100.0);

        return ResponseEntity.ok(resultat);
    }
}