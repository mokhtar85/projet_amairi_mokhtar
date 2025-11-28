package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.dto.ConseillerCreateDTO;
import com.example.projet_amairi_mokhtar.dto.ConseillerDTO;
import com.example.projet_amairi_mokhtar.entity.Conseiller;
import com.example.projet_amairi_mokhtar.service.ConseillerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @PostMapping
    public ResponseEntity<ConseillerDTO> createConseiller(@Valid @RequestBody ConseillerCreateDTO createDTO) {
        ConseillerDTO result = conseillerService.createConseiller(createDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);    }

    @GetMapping
    public ResponseEntity<List<ConseillerDTO>> getAllConseillers() {
        return ResponseEntity.ok(conseillerService.getAllConseillers());
    }
}