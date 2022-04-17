package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Employe;
import com.alweimine.banquesi.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listeEmplyees() {
        return employeRepository.findAll();
    }
}
