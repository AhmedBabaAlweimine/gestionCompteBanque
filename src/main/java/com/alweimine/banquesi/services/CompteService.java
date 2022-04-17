package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Compte;

import java.util.Optional;

public interface CompteService {

    public Compte SaveCompte(Compte cp);
    public Optional<Compte> getCompte(String code);

}
