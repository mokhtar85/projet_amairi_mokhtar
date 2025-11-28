package com.example.projet_amairi_mokhtar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirementDTO {
    private Long idCompteSource;
    private Long idCompteDestination;
    private double montant;
}
