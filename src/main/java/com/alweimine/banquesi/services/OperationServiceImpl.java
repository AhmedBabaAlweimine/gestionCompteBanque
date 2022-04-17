package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Compte;
import com.alweimine.banquesi.entities.Employe;
import com.alweimine.banquesi.entities.Operation;
import com.alweimine.banquesi.entities.Versement;
import com.alweimine.banquesi.repository.CompteRepository;
import com.alweimine.banquesi.repository.EmployeRepository;
import com.alweimine.banquesi.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService{
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;

    @Transactional
    @Override
    public boolean verser(String code, double montant, Long codeEmpl) {
        Compte cp=compteRepository.getOne(code);
        Employe emp=employeRepository.getOne(codeEmpl);
        Operation o=new Versement();
        o.setDateOperation(new Date());
        o.setMontanat((montant));
        o.setEmploye(emp);
        o.setCompte(cp);
        operationRepository.save(o);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
        return true;
    }

    @Transactional
    @Override
    public boolean retirer(String code, double montant, Long codeEmpl) {
        Compte cp=compteRepository.getOne(code);
        if(cp.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
        Employe emp=employeRepository.getOne(codeEmpl);
        Operation o=new Versement();
        o.setDateOperation(new Date());
        o.setMontanat((montant));
        o.setEmploye(emp);
        o.setCompte(cp);
        operationRepository.save(o);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
        return true;
    }

    @Override
    public boolean virement(String compt1, String compt2, double montant, Long codeEmpl) {
        retirer(compt1,montant,codeEmpl);
        verser(compt2,montant,codeEmpl);
        return true;
    }

    @Override
    public PageOperation getOperations(String codeCompte, int page, int size) {
        Page<Operation> ops=operationRepository.getOperations(codeCompte,new PageRequest(page,size));


        //si on veut utilisé la methode findByCompte
        Compte cp=compteRepository.getOne(codeCompte);
        Page<Operation> op2=operationRepository.findByCompte(cp,new PageRequest(page,size));


        PageOperation pageoperation= new PageOperation();
        pageoperation.setOperations(ops.getContent());
        pageoperation.setNombreOperations(ops.getNumberOfElements());
        pageoperation.setPage(ops.getNumber());
        pageoperation.setTotalPages(ops.getTotalPages());
        pageoperation.setTotalOperations((int) ops.getTotalElements());
        return pageoperation;
    }

}
