package com.example.projet_amairi_mokhtar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConseillerDTO {
    private Long id;
    private String nom;
    private String prenom;
}