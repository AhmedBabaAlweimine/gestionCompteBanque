package com.alweimine.banquesi.repository;

import com.alweimine.banquesi.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
