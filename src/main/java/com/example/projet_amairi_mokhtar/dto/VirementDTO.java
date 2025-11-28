package com.example.projet_amairi_mokhtar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirementDTO {

    @NotNull(message = "Le compte source est obligatoire")
    private Long idCompteSource;
    @NotNull(message = "Le compte destination est obligatoire")
    private Long idCompteDestination;
    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant du virement doit être strictement positif")
    @Min(value = 1, message = "Le montant minimum est de 1 euro")
    private double montant;
}
