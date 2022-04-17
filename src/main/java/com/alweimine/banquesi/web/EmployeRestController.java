package com.alweimine.banquesi.web;

import com.alweimine.banquesi.entities.Employe;
import com.alweimine.banquesi.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EmployeRestController {
    @Autowired
    private EmployeService employeService;

    @RequestMapping(value = "/employes",method = RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeService.saveEmploye(e);
    }


    @RequestMapping(value = "/employes",method = RequestMethod.GET)
    public List<Employe> listeEmplyees() {
        return employeService.listeEmplyees();
    }
}
