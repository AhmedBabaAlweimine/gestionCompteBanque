package com.alweimine.banquesi.web;

import com.alweimine.banquesi.entities.Compte;
import com.alweimine.banquesi.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ComptRestController {
    @Autowired
    private CompteService compteService;
    @RequestMapping(value = "/comptes",method = RequestMethod.POST)
    public Compte SaveCompte(@RequestBody  Compte cp) {
        return compteService.SaveCompte(cp);
    }
    @RequestMapping(value = "/comptes/{code}",method = RequestMethod.GET)
    public Optional<Compte> getCompte(@PathVariable String code) {
        return compteService.getCompte(code);
    }
}
