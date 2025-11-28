package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.entity.Conseiller;
import com.example.projet_amairi_mokhtar.service.ConseillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @PostMapping
    public ResponseEntity<Conseiller> createConseiller(@RequestBody Conseiller conseiller) {
        return ResponseEntity.ok(conseillerService.createConseiller(conseiller));
    }

    @GetMapping
    public ResponseEntity<List<Conseiller>> getAllConseillers() {
        return ResponseEntity.ok(conseillerService.getAllConseillers());
    }
}