package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Compte;

public interface OperationService {
    public boolean verser(String code, double montant,Long codeEmpl);
    public boolean retirer(String code, double montant,Long codeEmpl);
    public boolean virement(String compt1,String compt2, double montant,Long codeEmpl);
    public PageOperation getOperations(String codeCompte,int page,int size);
}
