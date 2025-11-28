package com.example.projet_amairi_mokhtar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConseillerCreateDTO {

    @NotBlank(message = "Le nom du conseiller est obligatoire")
    @Size(min = 2, message = "Le nom doit faire au moins 2 caractères")
    private String nom;

    @NotBlank(message = "Le prénom du conseiller est obligatoire")
    @Size(min = 2, message = "Le prénom doit faire au moins 2 caractères")
    private String prenom;
}