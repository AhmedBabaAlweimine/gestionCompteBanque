package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Compte;
import com.alweimine.banquesi.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService{
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Compte SaveCompte(Compte cp) {
        cp.setDateCreation(new Date());
        return compteRepository.save(cp);
    }

    @Override
    public Optional<Compte> getCompte(String code) {
        Optional<Compte> cp=compteRepository.findById(code);
        if(!cp.isPresent()){
            throw new RuntimeException("Aucun compte n'est associé avec le code:"+code);
        }
        return cp;
    }
}
