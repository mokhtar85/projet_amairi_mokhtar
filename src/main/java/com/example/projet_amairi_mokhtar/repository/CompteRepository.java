package com.example.projet_amairi_mokhtar.repository;

import com.example.projet_amairi_mokhtar.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

}