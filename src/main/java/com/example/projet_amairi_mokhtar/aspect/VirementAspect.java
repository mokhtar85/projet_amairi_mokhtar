package com.example.projet_amairi_mokhtar.aspect;

import com.example.projet_amairi_mokhtar.entity.Compte;
import com.example.projet_amairi_mokhtar.entity.CompteCourant;
import com.example.projet_amairi_mokhtar.repository.CompteRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class VirementAspect {

    private static final Logger logger = LoggerFactory.getLogger("VirementLogger");
    private final CompteRepository compteRepository;

    public VirementAspect(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }


    @AfterReturning(pointcut = "execution(* com.example.projet_amairi_mokhtar.service.VirementService.effectuerVirement(..)) && args(idSource, idDest, montant)", argNames = "idSource,idDest,montant")
    public void logVirement(Long idSource, Long idDest, double montant) {

        Compte source = compteRepository.findById(idSource).orElse(null);
        Compte dest = compteRepository.findById(idDest).orElse(null);

        if (source != null && dest != null) {
            String typeSource = (source instanceof CompteCourant) ? "COURANT" : "EPARGNE";
            String typeDest = (dest instanceof CompteCourant) ? "COURANT" : "EPARGNE";

            String logMessage = String.format(
                    "VIREMENT EXECUTE | Date: %s | Montant: %.2f | " +
                            "SOURCE [ID: %d, Num: %s, Type: %s] -> " +
                            "DESTINATION [ID: %d, Num: %s, Type: %s]",
                    LocalDateTime.now(),
                    montant,
                    idSource, source.getNumeroCompte(), typeSource,
                    idDest, dest.getNumeroCompte(), typeDest
            );

            logger.info(logMessage);
        }
    }
}