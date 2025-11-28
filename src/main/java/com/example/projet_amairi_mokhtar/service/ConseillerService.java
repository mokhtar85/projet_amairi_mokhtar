package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.entity.Conseiller;

import java.util.List;

public interface ConseillerService {

     Conseiller createConseiller(Conseiller conseiller);
     List<Conseiller> getAllConseillers();
}
