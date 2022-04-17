package com.alweimine.banquesi.services;

import com.alweimine.banquesi.entities.Employe;

import java.util.List;

public interface EmployeService {
    public Employe saveEmploye(Employe e);
    public List<Employe> listeEmplyees();
}
