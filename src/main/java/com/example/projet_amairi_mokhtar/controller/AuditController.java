package com.example.projet_amairi_mokhtar.controller;

import com.example.projet_amairi_mokhtar.service.AuditServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditServiceImpl auditService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAuditReport() {
        return ResponseEntity.ok(auditService.genererRapportAudit());
    }
}