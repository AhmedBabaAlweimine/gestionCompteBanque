package com.alweimine.banquesi.repository;

import com.alweimine.banquesi.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,String> {
}
