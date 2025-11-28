package com.example.projet_amairi_mokhtar.service;


import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {


    public double simulerMensualite(double montant, double tauxAnnuel, int dureeMois) {

        double tauxMensuel = (tauxAnnuel / 100) / 12;

        double mensualite = (montant * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeMois));

        return Math.round(mensualite * 100.0) / 100.0;
    }
}
