package com.example.projet_amairi_mokhtar.service;

import com.example.projet_amairi_mokhtar.dto.ConseillerCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ConseillerDTO;
import com.example.projet_amairi_mokhtar.entity.Conseiller;

import java.util.List;

public interface ConseillerService {

    ConseillerDTO createConseiller(ConseillerCreateDTO createDTO);
     List<ConseillerDTO> getAllConseillers();
}
