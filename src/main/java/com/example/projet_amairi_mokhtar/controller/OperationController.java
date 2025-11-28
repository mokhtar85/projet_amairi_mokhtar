package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.dto.VirementDTO;
import com.example.projet_amairi_mokhtar.service.VirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/operations")
@RequiredArgsConstructor
public class OperationController {

    private final VirementService virementService;

    @PostMapping("/virement")
    public ResponseEntity<Map<String, String>> virement(@RequestBody VirementDTO virementDTO) {

        virementService.effectuerVirement(
                virementDTO.getIdCompteSource(),
                virementDTO.getIdCompteDestination(),
                virementDTO.getMontant()
        );

        return ResponseEntity.ok(Collections.singletonMap("message", "votre virement a ete effectuer"));
    }
}